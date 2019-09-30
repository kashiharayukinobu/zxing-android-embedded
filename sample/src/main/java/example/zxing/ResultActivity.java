package example.zxing;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
    }

    //QRコード化する文字列
    String data = "https://www.google.com";
    //QRコード画像の大きさを指定(pixel)
    int size = 500;

    public void scanMixedBarcodes(View view) {
        BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
        //QRコードをBitmapで作成
        Bitmap bitmap = null;
        try {
            bitmap = barcodeEncoder.encodeBitmap(data, BarcodeFormat.QR_CODE, size, size);
        } catch (WriterException ex) {
            ex.printStackTrace();
        }

        //作成したQRコードを画面上に配置
        ImageView imageViewQrCode = (ImageView) findViewById(R.id.imageView);
        imageViewQrCode.setImageBitmap(bitmap);
    }
}


