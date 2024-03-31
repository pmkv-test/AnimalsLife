package service;

import animal.Animal;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Utils {
    public static LocalDate getRandomDate() {
        String startDate = "20-12-2015";
        String endDate = "10-03-2024";
        String format = "dd-MM-yyyy";

        try {
            LocalDate start = LocalDate.parse(startDate, DateTimeFormatter.ofPattern(format));
            LocalDate end = LocalDate.parse(endDate, DateTimeFormatter.ofPattern(format));

            long randomDays = ThreadLocalRandom.current().nextLong(0, start.until(end).getDays());
            LocalDate randomDate = start.plusDays(randomDays);
            return randomDate;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Animal[] listToArray(List<Animal> animals) {
        Animal[] animalArray = new Animal[animals.size()];
        animalArray = animals.toArray(animalArray);
        return animalArray;
    }

    public static int calculateAge(LocalDate birthDate) {
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(birthDate, currentDate);
        return period.getYears();
    }

    private static int[] generateRandomArray(int n) {
        Random random = new Random();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(100); // Генерация случайного числа от 0 до 99
        }
        return array;
    }

    /*
    Параллельная сортировка массива: Сгенерируйте массив n случайных чисел. Отсортируйте массив в многопоточном режиме.
    */
    public static int[] sortArrayMultiThreaded(int arraySize) {
        int[] arrayPool = generateRandomArray(arraySize);
        int processorCount = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(processorCount);
        int chunkSize = arrayPool.length / processorCount;
        int[][] chunks = new int[processorCount][];

        //разбиваем массиив на части
        for (int i = 0; i < processorCount; i++) {
            int start = i * chunkSize;
            int end = (i == processorCount - 1) ? arrayPool.length : (i + 1) * chunkSize;
            chunks[i] = Arrays.copyOfRange(arrayPool, start, end);
        }

        //сортуруем каждую часть в отдельном потоке
        Future<int[]>[] futures = new Future[processorCount];
        for (int i = 0; i < processorCount; i++) {
            int[] chunk = chunks[i];
            futures[i] = executor.submit(() -> {
                Arrays.sort(chunk);
                return chunk;
            });
        }

        //объединяем в один массив
        int[] sortedArray = new int[arrayPool.length];
        for (int i = 0; i < processorCount; i++) {
            try {
                int[] sortedChunk = futures[i].get();
                System.arraycopy(sortedChunk, 0, sortedArray, i * chunkSize, sortedChunk.length);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        Arrays.sort(sortedArray);
        executor.shutdown();
        System.out.println("Sorted Array: " + Arrays.toString(sortedArray));
        return sortedArray;
    }

    private static class ConcurrentCounter {
        private AtomicInteger count;

        public ConcurrentCounter() {
            this.count = new AtomicInteger(0);
        }

        public void increment() {
            count.incrementAndGet();
        }

        public int getCount() {
            return count.get();
        }
    }

    /*
    Потокобезопасный счетчик: Создайте класс счетчика, который можно увеличивать из нескольких потоков без использования синхронизации.
    Используйте атомарные операции или классы из пакета java.util.concurrent.atomic.
    */
    public static int counterMultiThreaded(int countThreads) {
        ConcurrentCounter counter = new ConcurrentCounter();
        Thread[] threads = new Thread[countThreads];
        for (int i = 0; i < countThreads; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    counter.increment();
                }
            });
            threads[i].start();
        }

        // Ждем завершения всех потоков
        for (int i = 0; i < countThreads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Final count: " + counter.getCount());
        return counter.getCount();
    }

    /*
    Параллельная генерация случайных чисел: Реализуйте генерацию n случайных чисел в однопоточном и многопоточном режиме,
    измерьте и сравните время исполнения для этих реализаций.
    */
    public static void generateRandomNumbersMultiThread(int numThreads, int numNumbers) {
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        for (int i = 0; i < numThreads; i++) {
            final int threadNum = i;
            executor.execute(() -> {
                Random random = new Random();
                int numbersPerThread = numNumbers / numThreads;
                for (int j = 0; j < numbersPerThread; j++) {
                    random.nextInt();
                }
                System.out.println("Thread " + threadNum + " finished generating " + numbersPerThread + " random numbers.");
            });
        }
        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
