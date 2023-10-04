package com.geekbrains.myfirsttests

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class EmailValidatorTest {

    @Test
    fun emailValidator_CorrectEmailSimple_ReturnsTrue() {
        assertTrue(EmailValidator.isValidEmail("name@email.com"))
    }

    @Test
    fun emailValidator_CorrectEmailSubDomain_ReturnsTrue() {
        assertTrue(EmailValidator.isValidEmail("name@email.co.uk"))
    }

    @Test
    fun emailValidator_InvalidEmailNoTld_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("name@email"))
    }

    @Test
    fun emailValidator_InvalidEmailDoubleDot_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("name@email..com"))
    }

    @Test
    fun emailValidator_InvalidEmailNoUsername_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("@email.com"))
    }

    @Test
    fun emailValidator_EmptyString_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail(""))
    }

    @Test
    fun emailValidator_NullEmail_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail(null))
    }

    @Test
    fun emailValidator_NoDomain_ReturnsFalse(){
        assertFalse(EmailValidator.isValidEmail("nameemail.com"))
    }

    @Test
    fun emailValidator_SpaceWithEmail_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail(" "))
        assertFalse(EmailValidator.isValidEmail("name @email.com"))
        assertFalse(EmailValidator.isValidEmail("name@e mail.com"))
    }

    @Test
    fun emailValidator_SpecialChars_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("name!@email.com"))
        assertFalse(EmailValidator.isValidEmail("na*me@email.com"))
        assertFalse(EmailValidator.isValidEmail("na^me@email.com"))
        assertFalse(EmailValidator.isValidEmail("\$name@email.com"))
        assertFalse(EmailValidator.isValidEmail("name@email.com?"))
    }

    @Test
    fun emailValidator_NoLatins_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("ИмяПочты@email.com"))
    }

    @Test
    fun emailValidator_InvalidLength_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("Abcdefghijklmnopqrstuvwxyz1Abcdefghijklmnopqrstuvwxyz2Abcdefghijklmnopqrstuvwxyz3Abcdefghijklmnopqrstuvwxyz4Abcdefghijklmnopqrstuvwxyz5Abcdefghijklmnopqrstuvwxyz6Abcdefghijklmnopqrstuvwxyz7Abcdefghijklmnopqrstuvwxyz8Abcdefghijklmnopqrstuvwxyz9Abcdefghijklmnopqrstuvwxyz10@email.com"))
        assertFalse(EmailValidator.isValidEmail("name@Abcdefghijklmnopqrstuvwxyz1Abcdefghijklmnopqrstuvwxyz2Abcdefghijklmnopqrstuvwxyz3.com"))
        assertFalse(EmailValidator.isValidEmail("name@email.Abcdefghijklmnopqrstuvwxyz1"))
    }

    @Test
    fun emailValidator_InvalidSubDomain_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("name@email.com."))
        assertFalse(EmailValidator.isValidEmail("name@email.com..."))
    }
}
