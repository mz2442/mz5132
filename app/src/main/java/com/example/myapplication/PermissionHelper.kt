package com.example.myapplication

import android.Manifest
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.appcompat.app.AppCompatActivity

/**
 * 权限申请助手类
 * 解决Android 6.0+动态权限申请问题
 */
object PermissionHelper {
    private const val PERMISSION_REQUEST_CODE = 1001
    
    /**
     * 检查并申请必要权限
     */
    fun checkAndRequestPermissions(activity: AppCompatActivity) {
        val permissionsToRequest = mutableListOf<String>()
        
        // 检查网络权限
        if (ContextCompat.checkSelfPermission(activity, Manifest.permission.INTERNET) 
            != PackageManager.PERMISSION_GRANTED) {
            permissionsToRequest.add(Manifest.permission.INTERNET)
        }
        
        // 检查存储权限
        if (ContextCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE) 
            != PackageManager.PERMISSION_GRANTED) {
            permissionsToRequest.add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        }
        
        if (permissionsToRequest.isNotEmpty()) {
            ActivityCompat.requestPermissions(
                activity, 
                permissionsToRequest.toTypedArray(), 
                PERMISSION_REQUEST_CODE
            )
        }
    }
    
    /**
     * 处理权限申请结果
     */
    fun onRequestPermissionsResult(activity: AppCompatActivity, requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        if (requestCode == PERMISSION_REQUEST_CODE) {
            val deniedPermissions = mutableListOf<String>()
            
            for (i in permissions.indices) {
                if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                    deniedPermissions.add(permissions[i])
                }
            }
            
            if (deniedPermissions.isNotEmpty()) {
                Toast.makeText(activity, "需要权限才能正常使用应用功能", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(activity, "权限申请成功", Toast.LENGTH_SHORT).show()
            }
        }
    }
}