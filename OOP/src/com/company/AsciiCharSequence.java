package com.company;

public class AsciiCharSequence implements CharSequence{

        private byte[] array;
        public AsciiCharSequence (byte[] arrayBytes) {
                this.array = arrayBytes;
        }
        @Override
        public String toString() {
            String arrayToString = new String(array);
            return arrayToString;
        }

        @Override
        public int length() {
            int counterOfArray = 0;
            for (byte element: array) {
                counterOfArray += 1;
            }
            return counterOfArray;
        }

        @Override
        public char charAt(int index) {
            char byteToChar = '\u0000';
            for (int i = 0; i < array.length; i++) {
               if (i == index) {
                   byteToChar = (char) array[i];
                   break;
               }
            }
            return byteToChar;
        }

        @Override
        public AsciiCharSequence subSequence(int start, int end) {
            int indexOfArray;
            byte[] subSequence = new byte[end - start];
            for (int index = 0; index < subSequence.length; index++) {
                subSequence[index] = array[start + index];
                indexOfArray = index + start;
                System.out.println("IndexOfArray = " + indexOfArray);
            }
            AsciiCharSequence subSequenceReturn = new AsciiCharSequence(subSequence);
            return subSequenceReturn;
        }

}
