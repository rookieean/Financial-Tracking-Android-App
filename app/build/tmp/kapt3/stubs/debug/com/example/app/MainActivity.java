package com.example.app;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.app.data.AppDatabase;
import com.example.app.data.TransactionEntity;
import com.example.app.databinding.ActivityMainBinding;
import com.example.app.ui.TransactionAdapter;
import kotlinx.coroutines.Dispatchers;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\u0012\u0010\u0015\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u0013H\u0002J\b\u0010\u0019\u001a\u00020\u0013H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001a"}, d2 = {"Lcom/example/app/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "adapter", "Lcom/example/app/ui/TransactionAdapter;", "binding", "Lcom/example/app/databinding/ActivityMainBinding;", "db", "Lcom/example/app/data/AppDatabase;", "getDb", "()Lcom/example/app/data/AppDatabase;", "db$delegate", "Lkotlin/Lazy;", "transactionDao", "Lcom/example/app/data/TransactionDao;", "getTransactionDao", "()Lcom/example/app/data/TransactionDao;", "transactionDao$delegate", "observeTotalBalance", "", "observeTransactions", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setupButton", "setupRecyclerView", "app_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.example.app.databinding.ActivityMainBinding binding;
    private com.example.app.ui.TransactionAdapter adapter;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy db$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy transactionDao$delegate = null;
    
    public MainActivity() {
        super();
    }
    
    private final com.example.app.data.AppDatabase getDb() {
        return null;
    }
    
    private final com.example.app.data.TransactionDao getTransactionDao() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupRecyclerView() {
    }
    
    private final void setupButton() {
    }
    
    private final void observeTransactions() {
    }
    
    private final void observeTotalBalance() {
    }
}