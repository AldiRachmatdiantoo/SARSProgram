# crudSqlKotlin

Ini adalah proyek Kotlin bernama "crudSqlKotlin". [cite_start]Proyek ini dibangun dengan Gradle [cite: 67] [cite_start]dan dikonfigurasi untuk menggunakan JDK 21 [cite: 67] [cite_start]dan Kotlin versi 2.1.21[cite: 67].

## Memulai

### Prasyarat

* [cite_start]**Java Development Kit (JDK):** Proyek ini membutuhkan JDK versi 21. Pastikan variabel lingkungan `JAVA_HOME` Anda diatur ke lokasi instalasi JDK yang benar, atau bahwa perintah `java` dapat ditemukan di `PATH` sistem Anda[cite: 10, 46].
* **MySQL:** Proyek ini memerlukan koneksi ke database MySQL. [cite_start]Koneksi ini difasilitasi oleh dependensi `mysql-connector-java` versi 8.0.33 yang disertakan dalam `build.gradle.kts`[cite: 67].

### Membangun dan Menjalankan Proyek

Proyek ini menggunakan Gradle Wrapper (`gradlew`) untuk memastikan lingkungan build yang konsisten.

**Untuk membangun proyek:**
Gunakan perintah berikut di terminal Anda:

* **Windows:**
    ```sh
    gradlew.bat build
    ```
* **Linux/macOS:**
    ```sh
    ./gradlew build
    ```

**Untuk menjalankan pengujian:**
[cite_start]Proyek ini menggunakan JUnit Platform untuk pengujian[cite: 67]. Anda dapat menjalankan semua pengujian dengan perintah berikut:

* **Windows:**
    ```sh
    gradlew.bat test
    ```
* **Linux/macOS:**
    ```sh
    ./gradlew test
    ```

### Konfigurasi JVM

Anda dapat menyesuaikan opsi JVM untuk skrip Gradle Wrapper. [cite_start]Opsi JVM default diatur ke `"-Xmx64m" "-Xms64m"`[cite: 9, 35]. [cite_start]Anda dapat menambahkan opsi kustom menggunakan variabel lingkungan `JAVA_OPTS` dan `GRADLE_OPTS`[cite: 8, 35].

## Struktur Proyek

* [cite_start]`settings.gradle.kts`: Mengatur nama proyek root menjadi "crudSqlKotlin" dan menerapkan plugin `org.gradle.toolchains.foojay-resolver-convention`[cite: 68].
* [cite_start]`build.gradle.kts`: Berisi konfigurasi build utama[cite: 67]:
    * [cite_start]**Plugins:** `kotlin("jvm")` versi "2.1.21"[cite: 67].
    * [cite_start]**Grup/Versi:** `group = "org.example"` dan `version = "1.0-SNAPSHOT"`[cite: 67].
    * [cite_start]**Repositories:** Menggunakan `mavenCentral()`[cite: 67].
    * [cite_start]**Dependencies:** Menyertakan `mysql:mysql-connector-java:8.0.33` untuk implementasi dan `kotlin("test")` untuk pengujian[cite: 67].
    * [cite_start]**Toolchain:** Menggunakan JVM toolchain versi 21[cite: 67].
* [cite_start]`.gitignore`: Mengabaikan file dan direktori umum yang dihasilkan oleh Gradle, IntelliJ IDEA, Kotlin, Eclipse, NetBeans, dan VS Code[cite: 69].
* [cite_start]`gradle.properties`: Berisi properti Gradle, termasuk `kotlin.code.style=official`[cite: 69].
* [cite_start]`gradlew` & `gradlew.bat`: Skrip wrapper Gradle untuk Linux/macOS dan Windows[cite: 5, 17]. [cite_start]Skrip ini secara otomatis mengunduh dan menggunakan versi Gradle yang benar, memastikan lingkungan yang konsisten di seluruh mesin[cite: 1, 13].

## Informasi Tambahan

* [cite_start]**Gradle Wrapper:** Skrip `gradlew` (dan `gradlew.bat`) memeriksa apakah `JAVA_HOME` diatur[cite: 10, 42]. [cite_start]Jika tidak diatur, ia mencoba mencari perintah `java` di `PATH` Anda[cite: 10, 46]. [cite_start]Jika tidak ditemukan, ia akan menampilkan pesan kesalahan[cite: 10, 44].
* [cite_start]**Sistem Operasi:** Skrip `gradlew` untuk Linux/macOS berisi logika khusus untuk menangani perbedaan antara sistem seperti Cygwin, Darwin (macOS), MSYS, dan NonStop[cite: 37, 38, 39, 40].
