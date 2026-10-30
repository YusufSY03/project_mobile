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