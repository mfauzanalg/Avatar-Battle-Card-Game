// File : ISummoned.java
// Handles the behaviour of Summoned Cards
package com.avatarduel.component;

public interface ISummoned {
    // mengubah keadaan kartu dari tertutup jadi terbuka dan mengembalikan true
    // bila kartu sudah terbuka, tidak lakukan apa-apa dan kembalikan false
    boolean flip();

    // mengubah posisi karakter dari menyerang jadi bertahan, atau sebaliknya
    void rotate();

    // bila dalam posisi menyerang, mengembalikan attack.
    // bila dalam posisi bertahan, mengembalikan defense
    // Tambahkan juga perubahan status dari skill card aura jika ada
    int getPositionValue();

    Card getCardInstance();
}