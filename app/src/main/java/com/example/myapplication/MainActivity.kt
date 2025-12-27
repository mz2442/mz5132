package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 检查并申请权限
        PermissionHelper.checkAndRequestPermissions(this)
        
        setupWindowInsets()
        setupCardClickListeners()
    }
    
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        PermissionHelper.onRequestPermissionsResult(this, requestCode, permissions, grantResults)
    }

    private fun setupWindowInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun animateClick(view: MaterialCardView, onComplete: () -> Unit) {
        // 先执行点击回调
        onComplete()
        
        // 简化的缩放动画效果
        view.animate()
            .scaleX(0.98f)
            .scaleY(0.98f)
            .setDuration(100)
            .withEndAction {
                // 恢复原大小
                view.animate()
                    .scaleX(1.0f)
                    .scaleY(1.0f)
                    .setDuration(100)
                    .start()
            }
            .start()
    }

    private fun animateButtonClick(button: MaterialButton, onComplete: () -> Unit) {
        // 先执行点击回调
        onComplete()
        
        // MaterialButton 已经有内置的涟漪效果，这里可以添加轻微的缩放
        button.animate()
            .scaleX(0.98f)
            .scaleY(0.98f)
            .setDuration(60)
            .withEndAction {
                button.animate()
                    .scaleX(1.0f)
                    .scaleY(1.0f)
                    .setDuration(60)
                    .start()
            }
            .start()
    }

    private fun setupCardClickListeners() {
        // 数据分析卡片
        findViewById<MaterialCardView>(R.id.feature_card_1)?.apply {
            setOnClickListener {
                animateClick(this) {
                    showToast("数据分析功能 - 即将开放")
                }
            }
        }

        // 智能推荐卡片
        findViewById<MaterialCardView>(R.id.feature_card_2)?.apply {
            setOnClickListener {
                animateClick(this) {
                    showToast("智能推荐功能 - 即将开放")
                }
            }
        }

        // 云同步卡片
        findViewById<MaterialCardView>(R.id.feature_card_3)?.apply {
            setOnClickListener {
                animateClick(this) {
                    showToast("云同步功能 - 即将开放")
                }
            }
        }

        // 安全保护卡片
        findViewById<MaterialCardView>(R.id.feature_card_4)?.apply {
            setOnClickListener {
                animateClick(this) {
                    launchSecurityProtection()
                }
            }
        }

        // 快速操作按钮
        setupQuickActionButtons()
    }

    private fun setupQuickActionButtons() {
        findViewById<MaterialButton>(R.id.settings_btn)?.apply {
            setOnClickListener {
                animateButtonClick(this) {
                    showToast("设置功能 - 即将开放")
                }
            }
        }

        findViewById<MaterialButton>(R.id.profile_btn)?.apply {
            setOnClickListener {
                android.util.Log.d("MainActivity", "个人资料按钮被点击")
                animateButtonClick(this) {
                    android.util.Log.d("MainActivity", "开始启动个人资料活动")
                    launchProfileActivity()
                }
            }
        }

        findViewById<MaterialButton>(R.id.notifications_btn)?.apply {
            setOnClickListener {
                animateButtonClick(this) {
                    showToast("通知功能 - 即将开放")
                }
            }
        }

        findViewById<MaterialButton>(R.id.help_btn)?.apply {
            setOnClickListener {
                animateButtonClick(this) {
                    showToast("帮助功能 - 即将开放")
                }
            }
        }

        // 顶部欢迎按钮
        findViewById<com.google.android.material.button.MaterialButton>(R.id.get_started_btn)?.apply {
            setOnClickListener {
                animateButtonClick(this) {
                    showToast("开始使用！欢迎使用现代化应用")
                }
            }
        }
    }

    private fun launchSecurityProtection() {
        showToast("正在启动安全保护功能...")
        
        // 模拟安全扫描过程
        simulateSecurityScan()
    }

    private fun simulateSecurityScan() {
        // 模拟安全扫描的延迟过程
        android.os.Handler(mainLooper).postDelayed({
            showToast("安全扫描完成 - 您的设备安全")
        }, 1500)
    }

    private fun launchProfileActivity() {
        // 启动个人资料界面
        android.util.Log.d("MainActivity", "正在创建启动个人资料的 Intent")
        val intent = Intent(this, ProfileActivity::class.java)
        android.util.Log.d("MainActivity", "Intent 创建完成，开始启动活动")
        startActivity(intent)
        android.util.Log.d("MainActivity", "startActivity 调用完成")
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
