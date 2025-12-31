package com.samai.soft.logic

import com.samai.soft.data.AppDatabase
import com.samai.soft.data.entities.Voucher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * المحرك المحاسبي الذكي لنظام السامعي سوفت
 * وظيفته: ترحيل السندات وتحديث أرصدة الحسابات فوراً
 */
class AccountingEngine(private val db: AppDatabase) {

    suspend fun postVoucher(voucher: Voucher) = withContext(Dispatchers.IO) {
        db.runInTransaction {
            // 1. تحديث رصيد الحساب المدين (زيادة)
            db.accountDao().updateAccountBalance(voucher.debitAccount, voucher.amount)
            
            // 2. تحديث رصيد الحساب الدائن (نقص)
            db.accountDao().updateAccountBalance(voucher.creditAccount, -voucher.amount)
            
            // ملاحظة: النظام هنا يطبق مبدأ القيد المزدوج تلقائياً
        }
    }

    fun calculateTotalBalance(accounts: List<com.samai.soft.data.entities.Account>): Double {
        return accounts.sumOf { it.balance }
    }
}