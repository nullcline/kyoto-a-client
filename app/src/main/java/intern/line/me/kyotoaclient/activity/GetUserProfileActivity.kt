package intern.line.me.kyotoaclient.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import intern.line.me.kyotoaclient.R
import intern.line.me.kyotoaclient.model.User
import intern.line.me.kyotoaclient.presenter.GetUserInfo
import kotlinx.android.synthetic.main.activity_get_user_profile.*

class GetUserProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_user_profile)

        val selectedId = intent.getLongExtra("longTapUserId", 1)

        user_profile_progress_bar.visibility = View.VISIBLE

        //非同期でユーザー情報を取ってくる
        GetUserInfo(selectedId) {
            setUserInfo(it)
        }.start()
    }

    fun setUserInfo(set_user: User) {

        user_name.text = set_user.name
        user_profile_progress_bar.visibility = View.INVISIBLE

    }
}
