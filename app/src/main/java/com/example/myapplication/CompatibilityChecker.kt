package com.example.myapplication

import android.content.Context
import android.os.Build
import android.widget.Toast

/**
 * SDK兼容性检查工具
 * 解决不同Android版本兼容性问题
 */
object CompatibilityChecker {
    
    /**
     * 检查设备SDK版本兼容性
     */
    fun checkSdkCompatibility(context: Context): Boolean {
        val sdkVersion = Build.VERSION.SDK_INT
        val minSdkVersion = Build.VERSION_CODES.LOLLIPOP // API 21
        val maxRecommendedSdkVersion = Build.VERSION_CODES.UPSIDE_DOWN_CAKE // API 34
        
        when {
            sdkVersion < minSdkVersion -> {
                showCompatibilityWarning(context, "Android版本过低", 
                    "需要Android 5.0 (API 21)或更高版本")
                return false
            }
            sdkVersion > maxRecommendedSdkVersion -> {
                showCompatibilityWarning(context, "Android版本过高", 
                    "可能存在兼容性问题，建议更新到最新版本")
                return false
            }
            else -> {
                return true
            }
        }
    }
    
    /**
     * 检查特定API是否可用
     */
    fun checkApiAvailability(context: Context, requiredApi: Int): Boolean {
        if (Build.VERSION.SDK_INT >= requiredApi) {
            return true
        } else {
            Toast.makeText(context, 
                "当前设备不支持此功能 (需要API $requiredApi)", 
                Toast.LENGTH_LONG).show()
            return false
        }
    }
    
    /**
     * 显示兼容性警告
     */
    private fun showCompatibilityWarning(context: Context, title: String, message: String) {
        Toast.makeText(context, "$title: $message", Toast.LENGTH_LONG).show()
    }
    
    /**
     * 获取设备信息用于调试
     */
    fun getDeviceInfo(): String {
        return """
            设备信息:
            Android版本: ${Build.VERSION.RELEASE}
            SDK版本: ${Build.VERSION.SDK_INT}
            设备型号: ${Build.MODEL}
            制造商: ${Build.MANUFACTURER}
        """.trimIndent()
    }
}