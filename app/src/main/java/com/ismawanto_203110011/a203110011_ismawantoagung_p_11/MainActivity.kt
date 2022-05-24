package com.ismawanto_203110011.a203110011_ismawantoagung_p_11

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
// TODO 1: Mengambil isi variabel dari kelas activity main
        val fileName = findViewById<EditText>(R.id.editFile)
        val fileData = findViewById<EditText>(R.id.editData)
        //Mengambil batton dari kelas activity main
        val btnSave = findViewById<Button>(R.id.btnSave)
        val btnView = findViewById<Button>(R.id.btnView)

        // TODO 2: Apabila btnSave ditekan fungsi-fungsi didalamnya akan dikerjakan
        btnSave.setOnClickListener {
            val file: String = fileName.text.toString()
            val data: String = fileData.text.toString()
            //Diguanakan untuk membuat aliran data berupa gambar
            val fileOutputStream: FileOutputStream
            try {
                fileOutputStream = openFileOutput(file, Context.MODE_PRIVATE)
                fileOutputStream.write(data.toByteArray())
            } catch (e: FileNotFoundException) {
                e.printStackTrace()
            } catch (e: NumberFormatException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            } catch (e: Exception) {
                e.printStackTrace()
            }
            Toast.makeText(applicationContext, "data save", Toast.LENGTH_LONG).show()
            fileName.text.clear()
            fileData.text.clear()
        }

        // TODO 3: Apabila btnView ditekan fungsi-fungsi didalamnya akan dikerjakan
        btnView.setOnClickListener {
            val filename = fileName.text.toString()
            if (filename.trim() != "") {
                val fileInputStream: FileInputStream? = openFileInput(filename)
                val inputStreamReader = InputStreamReader(fileInputStream)
                val bufferedReader = BufferedReader(inputStreamReader)
                val stringBuilder: StringBuilder = StringBuilder()
                var text: String?
                while (run {
                        text = bufferedReader.readLine()
                        text
                    } != null) {
                    stringBuilder.append(text)
                }
                //Menampilkan data di EditText
                fileData.setText(stringBuilder.toString()).toString()
            } else {
                Toast.makeText(applicationContext, "file name cannot be blank", Toast.LENGTH_LONG)
                    .show()
            }
        }

    }
}