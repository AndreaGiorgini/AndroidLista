package supergostei.example.com.lista;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class BancoListaOpenHelper extends SQLiteOpenHelper {
    public BancoListaOpenHelper(Context contexto, String nome,
                                CursorFactory fabrica, int versao) {
        super(contexto, nome, fabrica, versao);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String criarTabela = "CREATE TABLE produtos (_id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT);";
        db.execSQL(criarTabela);
        db.execSQL("INSERT INTO produtos (nome) VALUES ('Itens')");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
