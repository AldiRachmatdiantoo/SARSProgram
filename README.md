# SARSProgram

Ini adalah proyek Kotlin bernama "SARSProgram". Proyek ini dibangun dengan Gradle dan dikonfigurasi untuk menggunakan JDK 21 dan Kotlin versi 2.1.21.

## Memulai

### Prasyarat

* **Java Development Kit (JDK):** Proyek ini membutuhkan JDK versi 21. Pastikan variabel lingkungan `JAVA_HOME` Anda diatur ke lokasi instalasi JDK yang benar, atau bahwa perintah `java` dapat ditemukan di `PATH` sistem Anda.
* **MySQL:** Proyek ini memerlukan koneksi ke database MySQL. Koneksi ini difasilitasi oleh dependensi `mysql-connector-java` versi 8.0.33 yang disertakan dalam `build.gradle.kts`.

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
Proyek ini menggunakan JUnit Platform untuk pengujian. Anda dapat menjalankan semua pengujian dengan perintah berikut:

* **Windows:**
    ```sh
    gradlew.bat test
    ```
* **Linux/macOS:**
    ```sh
    ./gradlew test
    ```

### Konfigurasi JVM

Anda dapat menyesuaikan opsi JVM untuk skrip Gradle Wrapper. Opsi JVM default diatur ke `"-Xmx64m" "-Xms64m"`. Anda dapat menambahkan opsi kustom menggunakan variabel lingkungan `JAVA_OPTS` dan `GRADLE_OPTS`.

## Struktur Proyek

* `settings.gradle.kts`: Mengatur nama proyek root menjadi "SARSProgram" dan menerapkan plugin `org.gradle.toolchains.foojay-resolver-convention`.
* `build.gradle.kts`: Berisi konfigurasi build utama:
    * **Plugins:** `kotlin("jvm")` versi "2.1.21".
    * **Grup/Versi:** `group = "org.example"` dan `version = "1.0-SNAPSHOT"`.
    * **Repositories:** Menggunakan `mavenCentral()`.
    * **Dependencies:** Menyertakan `mysql:mysql-connector-java:8.0.33` untuk implementasi dan `kotlin("test")` untuk pengujian.
    * **Toolchain:** Menggunakan JVM toolchain versi 21.
* `.gitignore`: Mengabaikan file dan direktori umum yang dihasilkan oleh Gradle, IntelliJ IDEA, Kotlin, Eclipse, NetBeans, dan VS Code.
* `gradle.properties`: Berisi properti Gradle, termasuk `kotlin.code.style=official`.
* `gradlew` & `gradlew.bat`: Skrip wrapper Gradle untuk Linux/macOS dan Windows. Skrip ini secara otomatis mengunduh dan menggunakan versi Gradle yang benar, memastikan lingkungan yang konsisten di seluruh mesin.

## Informasi Tambahan

* **Gradle Wrapper:** Skrip `gradlew` (dan `gradlew.bat`) memeriksa apakah `JAVA_HOME` diatur. Jika tidak diatur, ia mencoba mencari perintah `java` di `PATH` Anda. Jika tidak ditemukan, ia akan menampilkan pesan kesalahan.
* **Sistem Operasi:** Skrip `gradlew` untuk Linux/macOS berisi logika khusus untuk menangani perbedaan antara sistem seperti Cygwin, Darwin (macOS), MSYS, dan NonStop.
