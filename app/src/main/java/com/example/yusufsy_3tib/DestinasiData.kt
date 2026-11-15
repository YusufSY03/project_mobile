package com.example.yusufsy_3tib

// Objek destinasi Bukittinggi
val jamGadang = DestinasiModel(
    "Jam Gadang",
    "Ikon sejarah dan landmark utama Kota Bukittinggi yang dibangun pada masa kolonial dengan atap khas rumah gadang Minangkabau.",
    R.drawable.jam_gadang,
    "Sejarah"
)

val ngaraiSianok = DestinasiModel(
    "Ngarai Sianok",
    "Lembah hijau nan curam dengan tebing patahan bumi yang menakjubkan, membentang di perbatasan Kota Bukittinggi dan Kabupaten Agam.",
    R.drawable.ngarai_sianok,
    "Alam"
)

val lobangJepang = DestinasiModel(
    "Lobang Jepang",
    "Kompleks terowongan bawah tanah bersejarah peninggalan masa pendudukan Jepang yang membentang di bawah kawasan Taman Panorama.",
    R.drawable.lubang_jepang,
    "Sejarah"
)

// Objek destinasi Kab. Lima Puluh Kota
val lembahHarau = DestinasiModel(
    "Lembah Harau",
    "Lembah hijau yang diapit tebing batu terjal setinggi ratusan meter dengan air terjun alami, di Kabupaten Lima Puluh Kota.",
    R.drawable.lembah_harau,
    "Alam"
)

val kelok9 = DestinasiModel(
    "Kelok 9",
    "Karya infrastruktur jembatan layang megah yang meliuk-liuk di antara perbukitan hijau tropis, menghubungkan Sumatera Barat dan Riau.",
    R.drawable.kelok9,
    "Alam"
)

// Objek destinasi Pesisir Selatan & Tanah Datar
val mandeh = DestinasiModel(
    "Kawasan Wisata Mandeh",
    "Gugusan pulau eksotis di pesisir selatan dengan perairan jernih nan tenang, sering dijuluki surga bahari Raja Ampat-nya Sumatera Barat.",
    R.drawable.mandeh1,
    "Alam"
)

val istanoBasa = DestinasiModel(
    "Istano Basa Pagaruyuang",
    "Kemegahan istana replika kebanggaan suku Minangkabau dengan arsitektur rumah gadang khas di Batusangkar.",
    R.drawable.pagaruyuang,
    "Budaya"
)

// Kumpulan daftar per daerah
val daftarBukittinggi = listOf(jamGadang, ngaraiSianok, lobangJepang)
val daftarLimaPuluhKota = listOf(lembahHarau, kelok9)
val daftarTanahDatar = listOf(istanoBasa)
val daftarPesisirSelatan = listOf(mandeh)

// Kumpulan daftar untuk Wishlist
val daftarWishlist = listOf(jamGadang, mandeh, lembahHarau, istanoBasa)

// Peta data daerah (Single Source of Truth untuk DaerahActivity)
val dataDaerah = mapOf(
    "Bukittinggi" to daftarBukittinggi,
    "Kab. Lima Puluh Kota" to daftarLimaPuluhKota,
    "Kab. Tanah Datar" to daftarTanahDatar,
    "Kab. Pesisir Selatan" to daftarPesisirSelatan
)

// Data Ulasan & Rating Pengunjung per Destinasi (Pertemuan 10 - RecyclerView)
val dataUlasanDestinasi = mapOf(
    "Jam Gadang" to listOf(
        UlasanModel("Rizky Pratama", "★ 5.0 / 5.0", "Suasana malam di sekitar Jam Gadang sangat ramai dan sejuk, cocok untuk jalan santai bersama keluarga."),
        UlasanModel("Siti Rahmawati", "★ 4.8 / 5.0", "Taman di sekitarnya bersih dan terawat. Banyak kuliner khas Minang di dekat area taman."),
        UlasanModel("Budi Santoso", "★ 4.9 / 5.0", "Ikon Bukittinggi yang wajib dikunjungi! Arsitektur atap Rumah Gadangnya sangat unik dan bersejarah."),
        UlasanModel("Nadia Putri", "★ 4.7 / 5.0", "Spot foto terbaik kalau datang pagi hari saat udara masih segar dan belum terlalu padat pengunjung.")
    ),
    "Ngarai Sianok" to listOf(
        UlasanModel("Andi Wijaya", "★ 5.0 / 5.0", "Pemandangan tebingnya luar biasa megah! Udara sangat sejuk dan menenangkan pikiran."),
        UlasanModel("Dina Mariana", "★ 4.9 / 5.0", "Lembahnya sangat asri, suara aliran sungai dan pepohonan hijau bikin betah berlama-lama.")
    ),
    "Lobang Jepang" to listOf(
        UlasanModel("Fajar Nugroho", "★ 4.8 / 5.0", "Tempat wisata sejarah yang sangat edukatif. Lorongnya panjang dan penerangannya sudah cukup baik."),
        UlasanModel("Larasati", "★ 4.7 / 5.0", "Sebaiknya menyewa pemandu lokal agar bisa mendengar cerita sejarah di setiap ruangan terowongan.")
    ),
    "Lembah Harau" to listOf(
        UlasanModel("Hendra Gunawan", "★ 5.0 / 5.0", "Tebing granitnya sangat eksotis, air terjunnya segar sekali. Salah satu wisata alam terbaik di Sumbar!"),
        UlasanModel("Maya Sari", "★ 4.9 / 5.0", "Banyak spot foto menarik dan penginapan homestay yang nyaman di sekitar lembah."),
        UlasanModel("Doni Saputra", "★ 4.8 / 5.0", "Perjalanan menuju lokasi sangat menyenangkan dengan pemandangan sawah dan tebing tinggi.")
    ),
    "Kelok 9" to listOf(
        UlasanModel("Ilham Ramadhan", "★ 4.9 / 5.0", "Desain jembatan layangnya sangat megah di tengah hutan bukit barisan. Pemandangannya keren!"),
        UlasanModel("Rina Amelia", "★ 4.8 / 5.0", "Tempat istirahat favorit saat perjalanan dari Pekanbaru menuju Bukittinggi. Banyak penjual jagung bakar.")
    ),
    "Kawasan Wisata Mandeh" to listOf(
        UlasanModel("Dimas Anggara", "★ 5.0 / 5.0", "Air lautnya tenang dan jernih, gugusan pulaunya benar-benar mirip Raja Ampat. Wajib naik boat keliling pulau!"),
        UlasanModel("Putri Ayu", "★ 4.9 / 5.0", "Pemandangan dari Puncak Mandeh sangat memukau, snorkeling di sini juga seru banget.")
    ),
    "Istano Basa Pagaruyuang" to listOf(
        UlasanModel("Zaki Mubarak", "★ 5.0 / 5.0", "Ukiran dinding dan kemegahan istananya luar biasa. Kita juga bisa menyewa pakaian adat Minang untuk berfoto."),
        UlasanModel("Tari Oktavia", "★ 4.9 / 5.0", "Halamannya luas dan bersih, koleksi peninggalan budaya di dalam istana sangat terawat.")
    )
)

val ulasanDefault = listOf(
    UlasanModel("Pengunjung Ranah", "★ 5.0 / 5.0", "Destinasi wisata Sumatera Barat yang sangat indah, bersih, dan wajib dikunjungi!")
)