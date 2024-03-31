package service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    @DisplayName("Параллельная сортировка массива")
    @Test
    void sortArrayMultiThreaded() {
        int arraySize=30;
        int[] sortedArray = Utils.sortArrayMultiThreaded(arraySize);
        assertEquals(30, sortedArray.length);
    }

    @DisplayName("Потокобезопасный счетчик")
    @Test
    void counterMultiThreaded(){
        int count =  Utils.counterMultiThreaded(3);
        assertEquals(3000, count);
        count =  Utils.counterMultiThreaded(1);
        assertEquals(1000, count);
    }

    @DisplayName("Параллельная генерация случайных чисел")
    @Test
    void randomNumberMultiThreaded() {
        //генерация случайных чисел в одном потоке
        int numThreads = 1;
        int numNumbers = 1000000;
        long startTimeSingleThread = System.currentTimeMillis();
        Utils.generateRandomNumbersMultiThread(numThreads, numNumbers);
        long endTimeSingleThread = System.currentTimeMillis();
        long singleThreadTime = endTimeSingleThread - startTimeSingleThread;
        System.out.println("singleThreadTime " + singleThreadTime);

        //генерация случайных чисел в numThreads потоках
        numThreads = 5;
        long startTimeMultiThread = System.currentTimeMillis();
        Utils.generateRandomNumbersMultiThread(numThreads, numNumbers);
        long endTimeMultiThread = System.currentTimeMillis();
        long multiThreadTime = endTimeMultiThread - startTimeMultiThread;
        System.out.println("multiThreadTime " + multiThreadTime);
        //если время генерации в нескольких потоках меньше то тест пройден
        assertEquals(true, multiThreadTime < singleThreadTime);
    }
}