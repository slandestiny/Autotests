package ru.netology

import calculateComission
import comissionForMasterCardAndMaestro
import comissionForVisaAndMir
import limit
import org.junit.Test

import org.junit.Assert.*
import printResult

class MainKtTest {

    @Test
    fun printResult_Default() {
        // arrange
        val cardType = "Visa"
        val lastMonthAmount = 0.0
        val amount = 10_000.0
        // act
        val result = printResult(
            cardType = cardType,
            lastMonthAmount = lastMonthAmount,
            amount = amount
        )
        // assert
        assertEquals("Комиссия за перевод 10000.0 рублей по карте/счету Visa составила 75.0 рублей", result)
    }
    @Test
    fun printResult_OverLimit() {
        // arrange
        val cardType = "Visa"
        val lastMonthAmount = 0.0
        val amount = 100_000_000.0
        // act
        val result = printResult(
            cardType = cardType,
            lastMonthAmount = lastMonthAmount,
            amount = amount
        )
        // assert
        assertEquals("ЛИМИТ ПРЕВЫШЕН", result)
    }
    @Test
    fun comissionForMasterCardAndMaestro_Default() {
        // arrange
        val lastMonthAmount = 0.0
        val amount = 1_000.0
        // act
        val result = comissionForMasterCardAndMaestro(
            lastMonthAmount = lastMonthAmount,
            amount = amount
        )
        // assert
        assertEquals(0.0, result, 0.0)
    }
    @Test
    fun comissionForMasterCardAndMaestro_Comission() {
        // arrange
        val lastMonthAmount = 100_000.0
        val amount = 1_000.0
        // act
        val result = comissionForMasterCardAndMaestro(
            lastMonthAmount = lastMonthAmount,
            amount = amount
        )
        // assert
        assertEquals(26.0, result, 0.0)
    }
    @Test
    fun comissionForVisaAndMir_Default() {
        // arrange
        val amount = 1_000.0
        // act
        val result = comissionForVisaAndMir(
            amount = amount
        )
        // assert
        assertEquals(35.0, result, 0.0)
    }
    @Test
    fun comissionForVisaAndMir_Comission() {
        // arrange
        val amount = 10_000.0
        // act
        val result = comissionForVisaAndMir(
            amount = amount
        )
        // assert
        assertEquals(75.0, result, 0.0)
    }
    @Test
    fun limit_VkPay_True_MonthAmount() {
        // arrange
        val cardType = "Vk Pay"
        val lastMonthAmount = 100_000.0
        val amount = 1_000.0
        // act
        val result = limit(
            cardType = cardType,
            lastMonthAmount = lastMonthAmount,
            amount = amount
        )
        // assert
        assertEquals(true, result)
    }
    @Test
    fun limit_VkPay_True_Amount() {
        // arrange
        val cardType = "Vk Pay"
        val lastMonthAmount = 1_000.0
        val amount = 100_000.0
        // act
        val result = limit(
            cardType = cardType,
            lastMonthAmount = lastMonthAmount,
            amount = amount
        )
        // assert
        assertEquals(true, result)
    }
    @Test
    fun limit_VkPay_False() {
        // arrange
        val cardType = "Vk Pay"
        val lastMonthAmount = 0.0
        val amount = 100.0
        // act
        val result = limit(
            cardType = cardType,
            lastMonthAmount = lastMonthAmount,
            amount = amount
        )
        // assert
        assertEquals(false, result)
    }
    @Test
    fun limit_Mastercard_True_MonthAmount() {
        // arrange
        val cardType = "Mastercard"
        val lastMonthAmount = 1_000_000.0
        val amount = 1_000.0
        // act
        val result = limit(
            cardType = cardType,
            lastMonthAmount = lastMonthAmount,
            amount = amount
        )
        // assert
        assertEquals(true, result)
    }
    @Test
    fun limit_Mastercard_True_Amount() {
        // arrange
        val cardType = "Mastercard"
        val lastMonthAmount = 1_000.0
        val amount = 1_000_000.0
        // act
        val result = limit(
            cardType = cardType,
            lastMonthAmount = lastMonthAmount,
            amount = amount
        )
        // assert
        assertEquals(true, result)
    }
    @Test
    fun limit_Mastercard_False() {
        // arrange
        val cardType = "Mastercard"
        val lastMonthAmount = 0.0
        val amount = 100.0
        // act
        val result = limit(
            cardType = cardType,
            lastMonthAmount = lastMonthAmount,
            amount = amount
        )
        // assert
        assertEquals(false, result)
    }
    @Test
    fun limit_Maestro_True_MonthAmount() {
        // arrange
        val cardType = "Maestro"
        val lastMonthAmount = 1_000_000.0
        val amount = 1_000.0
        // act
        val result = limit(
            cardType = cardType,
            lastMonthAmount = lastMonthAmount,
            amount = amount
        )
        // assert
        assertEquals(true, result)
    }
    @Test
    fun limit_Maestro_True_Amount() {
        // arrange
        val cardType = "Maestro"
        val lastMonthAmount = 1_000.0
        val amount = 1_000_000.0
        // act
        val result = limit(
            cardType = cardType,
            lastMonthAmount = lastMonthAmount,
            amount = amount
        )
        // assert
        assertEquals(true, result)
    }
    @Test
    fun limit_Maestro_False() {
        // arrange
        val cardType = "Maestro"
        val lastMonthAmount = 0.0
        val amount = 100.0
        // act
        val result = limit(
            cardType = cardType,
            lastMonthAmount = lastMonthAmount,
            amount = amount
        )
        // assert
        assertEquals(false, result)
    }
    @Test
    fun limit_Visa_True_MonthAmount() {
        // arrange
        val cardType = "Visa"
        val lastMonthAmount = 1_000_000.0
        val amount = 1_000.0
        // act
        val result = limit(
            cardType = cardType,
            lastMonthAmount = lastMonthAmount,
            amount = amount
        )
        // assert
        assertEquals(true, result)
    }
    @Test
    fun limit_Visa_True_Amount() {
        // arrange
        val cardType = "Visa"
        val lastMonthAmount = 1_000.0
        val amount = 1_000_000.0
        // act
        val result = limit(
            cardType = cardType,
            lastMonthAmount = lastMonthAmount,
            amount = amount
        )
        // assert
        assertEquals(true, result)
    }
    @Test
    fun limit_Visa_False() {
        // arrange
        val cardType = "Visa"
        val lastMonthAmount = 0.0
        val amount = 100.0
        // act
        val result = limit(
            cardType = cardType,
            lastMonthAmount = lastMonthAmount,
            amount = amount
        )
        // assert
        assertEquals(false, result)
    }
    @Test
    fun limit_Mir_True_MonthAmount() {
        // arrange
        val cardType = "Мир"
        val lastMonthAmount = 1_000_000.0
        val amount = 1_000.0
        // act
        val result = limit(
            cardType = cardType,
            lastMonthAmount = lastMonthAmount,
            amount = amount
        )
        // assert
        assertEquals(true, result)
    }
    @Test
    fun limit_Mir_True_Amount() {
        // arrange
        val cardType = "Мир"
        val lastMonthAmount = 1_000.0
        val amount = 1_000_000.0
        // act
        val result = limit(
            cardType = cardType,
            lastMonthAmount = lastMonthAmount,
            amount = amount
        )
        // assert
        assertEquals(true, result)
    }
    @Test
    fun limit_Mir_False() {
        // arrange
        val cardType = "Мир"
        val lastMonthAmount = 0.0
        val amount = 100.0
        // act
        val result = limit(
            cardType = cardType,
            lastMonthAmount = lastMonthAmount,
            amount = amount
        )
        // assert
        assertEquals(false, result)
    }
    @Test
    fun limit_False_IncorrectedName() {
        // arrange
        val cardType = "Pay"
        val lastMonthAmount = 0.0
        val amount = 100.0
        // act
        val result = limit(
            cardType = cardType,
            lastMonthAmount = lastMonthAmount,
            amount = amount
        )
        // assert
        assertEquals(false, result)
    }
    @Test
    fun calculateComission_VkPay() {
        // arrange
        val cardType = "Vk Pay"
        val lastMonthAmount = 0.0
        val amount = 100_000_000.0
        // act
        val result = calculateComission(
            cardType = cardType,
            lastMonthAmount = lastMonthAmount,
            amount = amount
        )
        // assert
        assertEquals(0.0, result, 0.0)
    }
    @Test
    fun calculateComission_IncorrectedName() {
        // arrange
        val cardType = "Pay"
        val lastMonthAmount = 0.0
        val amount = 100_000_000.0
        // act
        val result = calculateComission(
            cardType = cardType,
            lastMonthAmount = lastMonthAmount,
            amount = amount
        )
        // assert
        assertEquals(0.0, result, 0.0)
    }
    @Test
    fun calculateComission_Mastercard_WithoutComission() {
        // arrange
        val cardType = "Mastercard"
        val lastMonthAmount = 0.0
        val amount = 1_000.0
        // act
        val result = calculateComission(
            cardType = cardType,
            lastMonthAmount = lastMonthAmount,
            amount = amount
        )
        // assert
        assertEquals(0.0, result, 0.0)
    }
    @Test
    fun calculateComission_Mastercard_WithComission() {
        // arrange
        val cardType = "Mastercard"
        val lastMonthAmount = 100_000.0
        val amount = 1_000.0
        // act
        val result = calculateComission(
            cardType = cardType,
            lastMonthAmount = lastMonthAmount,
            amount = amount
        )
        // assert
        assertEquals(26.0, result, 0.0)
    }
    @Test
    fun calculateComission_Maestro_WithoutComission() {
        // arrange
        val cardType = "Maestro"
        val lastMonthAmount = 0.0
        val amount = 1_000.0
        // act
        val result = calculateComission(
            cardType = cardType,
            lastMonthAmount = lastMonthAmount,
            amount = amount
        )
        // assert
        assertEquals(0.0, result, 0.0)
    }
    @Test
    fun calculateComission_Maestro_WithComission() {
        // arrange
        val cardType = "Maestro"
        val lastMonthAmount = 100_000.0
        val amount = 1_000.0
        // act
        val result = calculateComission(
            cardType = cardType,
            lastMonthAmount = lastMonthAmount,
            amount = amount
        )
        // assert
        assertEquals(26.0, result, 0.0)
    }
    @Test
    fun calculateComission_Visa_MinimalComission() {
        // arrange
        val cardType = "Visa"
        val lastMonthAmount = 0.0
        val amount = 1_000.0
        // act
        val result = calculateComission(
            cardType = cardType,
            lastMonthAmount = lastMonthAmount,
            amount = amount
        )
        // assert
        assertEquals(35.0, result, 0.0)
    }
    @Test
    fun calculateComission_Visa_WithComission() {
        // arrange
        val cardType = "Visa"
        val lastMonthAmount = 100_000.0
        val amount = 10_000.0
        // act
        val result = calculateComission(
            cardType = cardType,
            lastMonthAmount = lastMonthAmount,
            amount = amount
        )
        // assert
        assertEquals(75.0, result, 0.0)
    }
    @Test
    fun calculateComission_Mir_MinimalComission() {
        // arrange
        val cardType = "Мир"
        val lastMonthAmount = 0.0
        val amount = 1_000.0
        // act
        val result = calculateComission(
            cardType = cardType,
            lastMonthAmount = lastMonthAmount,
            amount = amount
        )
        // assert
        assertEquals(35.0, result, 0.0)
    }
    @Test
    fun calculateComission_Mir_WithComission() {
        // arrange
        val cardType = "Мир"
        val lastMonthAmount = 100_000.0
        val amount = 10_000.0
        // act
        val result = calculateComission(
            cardType = cardType,
            lastMonthAmount = lastMonthAmount,
            amount = amount
        )
        // assert
        assertEquals(75.0, result, 0.0)
    }
}