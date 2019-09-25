package supergostei.example.com.lista;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class Dao {

    private static final String NOME_DO_BANCO = "Lista";
    private SQLiteDatabase banco;
    private BancoListaOpenHelper bancoOpenHelper;
    public Dao(Context context) {
        bancoOpenHelper = new BancoListaOpenHelper(context, NOME_DO_BANCO, null, 1);
    }
    public void abrir() throws SQLException {
        banco = bancoOpenHelper.getWritableDatabase();
    }
    public void fechar() {
        if (banco != null)
            banco.close();
    }
    public void inserirProduto(String nome) {
        ContentValues novoProduto = new ContentValues();
        novoProduto.put("nome", nome);
        banco.insert("produtos", null, novoProduto);
    }
    public void alterarProduto(long id, String nome) {
        ContentValues produtoAlterado = new ContentValues();
        produtoAlterado.put("nome", nome);
        banco.update("produtos", produtoAlterado, "_id = " + id, null);
    }
    public void removerProduto(long id) {
        banco.delete("produtos", "_id = " + id, null);
    }
    public Cursor obterTodosOsProdutos() {
        return banco.query("produtos", null, null, null, null, null, "nome");
    }
    public Cursor obterUmProduto(long id) {
        return banco.query("produtos", null, "_id = " + id, null, null, null, null);
    }
}
