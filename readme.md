# 📱 Personal Finance Tracker

Aplikasi Android sederhana untuk melacak keuangan pribadi Anda. Dibangun dengan Kotlin menggunakan Android Studio, aplikasi ini memungkinkan Anda mencatat transaksi keuangan dan melihat total saldo secara real-time.

## ✨ Fitur

- **Total Saldo Real-time**: Menampilkan total saldo di bagian atas layar
- **Input Transaksi**: Form sederhana untuk menambahkan nama transaksi dan nominal
- **Riwayat Transaksi**: Daftar semua transaksi yang pernah dicatat menggunakan RecyclerView
- **Penyimpanan Lokal**: Data disimpan secara lokal menggunakan Room Database
- **UI Modern**: Desain bersih dan modern menggunakan Material Components

## 🛠️ Teknologi yang Digunakan

- **Kotlin** - Bahasa pemrograman utama
- **Android SDK** - Min SDK 27 (Android 8.1 Oreo)
- **Room Database** - Database lokal untuk menyimpan transaksi
- **View Binding** - Untuk mengakses view dengan type-safe
- **Material Components** - Komponen UI modern
- **Coroutines & Flow** - Untuk operasi asynchronous dan reactive data
- **RecyclerView** - Menampilkan daftar transaksi

## 📋 Requirements

- Android Studio (Hedgehog atau lebih baru)
- JDK 17 atau 11 (untuk Gradle)
- Android SDK dengan API Level 27 atau lebih tinggi
- Perangkat Android dengan Android 8.1 (API 27) atau lebih tinggi

## 🚀 Cara Install & Build

### 1. Clone atau Download Project

```bash
git clone <repository-url>
cd EXP02
```

### 2. Buka di Android Studio

1. Buka Android Studio
2. Pilih **File > Open** dan pilih folder project
3. Tunggu Android Studio melakukan sync dengan Gradle

### 3. Build APK

**Via Android Studio (Recommended):**
1. Klik menu **Build** → **Build Bundle(s) / APK(s)** → **Build APK(s)**
2. Tunggu proses build selesai
3. File APK akan tersimpan di: `app/build/outputs/apk/debug/app-debug.apk`

**Via Command Line:**
```bash
# Pastikan Gradle JDK sudah dikonfigurasi ke JDK 17 atau 11
.\gradlew.bat assembleDebug
```

### 4. Install ke Perangkat

1. Transfer file `app-debug.apk` ke perangkat Android Anda
2. Aktifkan **Install from Unknown Sources** di pengaturan perangkat
3. Buka file APK dan ikuti instruksi instalasi

## 📁 Struktur Project

```
app/
├── src/
│   └── main/
│       ├── java/com/example/app/
│       │   ├── MainActivity.kt          # Activity utama dengan logika aplikasi
│       │   ├── data/
│       │   │   ├── TransactionEntity.kt  # Entity untuk tabel transaksi
│       │   │   ├── TransactionDao.kt     # DAO untuk operasi database
│       │   │   └── AppDatabase.kt        # Database Room
│       │   └── ui/
│       │       └── TransactionAdapter.kt # Adapter untuk RecyclerView
│       ├── res/
│       │   ├── layout/
│       │   │   ├── activity_main.xml     # Layout utama
│       │   │   └── item_transaction.xml   # Layout item RecyclerView
│       │   └── values/
│       │       ├── strings.xml           # String resources
│       │       ├── themes.xml            # Theme aplikasi
│       │       └── colors.xml             # Warna aplikasi
│       └── AndroidManifest.xml
└── build.gradle                          # Konfigurasi build
```

## 💡 Penjelasan Kode

### MainActivity.kt

Activity utama yang menghubungkan UI dengan database:

- **View Binding**: Menggunakan `ActivityMainBinding` untuk mengakses view dengan aman
- **Room Database**: Menggunakan singleton pattern untuk instance database
- **Coroutines**: Operasi database dijalankan di background thread (`Dispatchers.IO`)
- **Flow**: Menggunakan Flow untuk reactive updates - UI otomatis update ketika data berubah

**Fungsi Utama:**
- `setupRecyclerView()` - Inisialisasi RecyclerView dengan adapter
- `setupButton()` - Handler untuk tombol "Tambah" yang menyimpan transaksi ke database
- `observeTransactions()` - Mengamati perubahan data transaksi dan update RecyclerView
- `observeTotalBalance()` - Mengamati perubahan total saldo dan update TextView

### TransactionEntity.kt

Entity Room yang merepresentasikan tabel `transactions`:

```kotlin
@Entity(tableName = "transactions")
data class TransactionEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val amount: Long
)
```

- `@Entity` - Menandakan ini adalah tabel database
- `@PrimaryKey(autoGenerate = true)` - ID otomatis bertambah

### TransactionDao.kt

Data Access Object untuk operasi CRUD:

- `insert()` - Menyimpan transaksi baru
- `getAllTransactions()` - Mengambil semua transaksi (mengembalikan Flow)
- `getTotalBalance()` - Menghitung total saldo (mengembalikan Flow)

### AppDatabase.kt

Database Room dengan singleton pattern:

- Menggunakan `Room.databaseBuilder()` untuk membuat instance database
- Nama database: `personal_finance_db`
- Version: 1

### TransactionAdapter.kt

Adapter untuk RecyclerView yang menampilkan daftar transaksi:

- Menggunakan View Binding untuk item layout
- `submitList()` - Update data RecyclerView ketika ada perubahan

## 🎨 UI Components

- **MaterialCardView** - Kartu untuk Total Saldo dan Form Input
- **TextInputLayout & TextInputEditText** - Input field dengan Material Design
- **RecyclerView** - Menampilkan daftar transaksi
- **ConstraintLayout** - Layout utama dengan constraint-based positioning

## 📝 Cara Menggunakan

1. **Menambah Transaksi**:
   - Isi field "Nama Transaksi" dengan nama transaksi (contoh: "Makan Siang")
   - Isi field "Nominal" dengan jumlah uang (contoh: 50000)
   - Klik tombol "Tambah"

2. **Melihat Total Saldo**:
   - Total saldo otomatis terupdate di bagian atas layar

3. **Melihat Riwayat**:
   - Semua transaksi yang pernah ditambahkan akan muncul di daftar bawah
   - Transaksi terbaru muncul di paling atas

## 🔧 Konfigurasi

### Mengubah Min SDK

Edit `app/build.gradle`:
```gradle
defaultConfig {
    minSdk 27  // Ubah sesuai kebutuhan
}
```

### Mengubah Nama Aplikasi

Edit `app/src/main/res/values/strings.xml`:
```xml
<string name="app_name">Nama Aplikasi Anda</string>
```

## 🐛 Troubleshooting

### Error: "Unsupported class file major version"
- Pastikan Gradle JDK dikonfigurasi ke JDK 17 atau 11 di Android Studio
- Settings → Build, Execution, Deployment → Build Tools → Gradle → Gradle JDK

### Error: "Plugin not found"
- Pastikan `settings.gradle` sudah dikonfigurasi dengan benar
- Sync project dengan Gradle Files

### Error: "Resource not found"
- Pastikan semua resource (themes.xml, colors.xml, icon) sudah dibuat
- Clean dan Rebuild project

## 📄 License

Project ini dibuat untuk tujuan pembelajaran.

## Demo

## 👨‍💻 Author

Dibuat sebagai project pembelajaran untuk pemula yang berpindah dari web development ke Android development.

---

**Note**: Project ini menggunakan View Binding (bukan findViewById) dan Room Database untuk best practices Android modern.
