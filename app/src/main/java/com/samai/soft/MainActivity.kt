package com.samai.soft

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.samai.soft.ui.screens.LoginScreen

/**
 * نقطة الانطلاق الرئيسية لتطبيق السامعي سوفت
 * هذا الملف هو الذي يستدعيه نظام أندرويد عند فتح الأيقونة
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        setContent {
            // متغير للتحكم في حالة الدخول (هل المستخدم سجل دخوله أم لا؟)
            var isLoggedIn by remember { mutableStateOf(false) }

            if (!isLoggedIn) {
                // عرض شاشة الدخول أولاً
                LoginScreen(onLoginSuccess = {
                    isLoggedIn = true
                })
            } else {
                // هنا سيتم عرض الشاشة الرئيسية للمحاسبة بعد نجاح الدخول
                // سنقوم ببرمجتها في الخطوات القادمة
                androidx.compose.material.Text(text = "مرحباً بك في لوحة تحكم السامعي سوفت")
            }
        }
    }
}