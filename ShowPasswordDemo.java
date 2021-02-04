
import android.app.Activity;
import android.os.Bundle;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import com.example.memorydemo.R;

public class ShowPasswordDemo extends Activity {

    @Override
    protected void onCreate(Bundle onSavedInstance) {
        super.onCreate(onSavedInstance);
        setContentView(R.layout.show_password_demo);

        final EditText editText = findViewById(R.id.editTextPassword);
        CheckBox checkBox = findViewById(R.id.checkBoxShowPassword);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    // 用户想要显示密码
                    editText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {

                    // 用户想要隐藏密码
                    editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }

                // 切换后将 EditText的光标置于末尾
                CharSequence charSequence = editText.getText();
                if (charSequence != null) {
                    Spannable spanText = (Spannable) charSequence;
                    Selection.setSelection(spanText, charSequence.length());
                }
            }
        });
    }
}
