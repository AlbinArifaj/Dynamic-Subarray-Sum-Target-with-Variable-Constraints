import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
//        int[] a = {-3,-1,-10,-9};
//        ArrayList<Result> results = findSubs(a, -20, 1,4 , -100, 100);
//        int[] a = {1,2,3,4,5};
//        ArrayList<Result> results = findSubs(a, 5, 1,4 , -100, 100);
//        int[] a = {0,0,1,0,0};
//        ArrayList<Result> results = findSubs(a, 1, 1,4 , -100, 100);
//        int[] a = {0,0,0,0,0};
//        ArrayList<Result> results = findSubs(a, 0, 1,3 , -100, 100);
//        int[] a = {7,2,3};
//        ArrayList<Result> results = findSubs(a, 12, 1,4 , 4, 100);
//        int[] a = {10,10,10,10,10};
//        ArrayList<Result> results = findSubs(a, 10, 1,4 , -100, 100);
//        int[] a = {1,-1,2,-2,3,3};
//        ArrayList<Result> results = findSubs(a, 3, 1,3 , -100, 100);
//        int[] a = {7,4,3,7,6,1};
//        ArrayList<Result> results = findSubs(a, 7, 1,1 , -100, 100);
        int[] a = {9,10,1,20,10,10};
        ArrayList<Result> results = findSubs(a, 20, 2,50 , 9, 100);






        printRes(results);
    }
    public static ArrayList<Result> findSubs(int[] nums, int target, int min, int max, int minvalue, int maxvalue) throws Exception {


        if (nums.length == 0 || min>max|| minvalue >maxvalue) {
            return new ArrayList<>();
        }

        int keepRange = 0;
        int end = 0;
        int start = 0;
        int currentSum = 0;
        ArrayList<Result> res = new ArrayList<>();


        while (start <=nums.length-min) {
            if (keepRange > max) {
                currentSum -= nums[start];
                keepRange -= 1;
                start += 1;
            } else if (keepRange < min) {
                if (nums[end] >= minvalue && nums[end] <= maxvalue) {
                    currentSum += nums[end];
                    keepRange += 1;
                    end += 1;
                } else {
                    currentSum = 0;
                    end += 1;
                    keepRange = 0;
                    start = end;
                }
            } else {
                if (Math.abs(currentSum)> Math.abs(target)) {
                    currentSum -= nums[start];
                    start += 1;
                    keepRange -= 1;

                } else if (Math.abs(currentSum) < Math.abs(target) && keepRange<max && end< nums.length) {
                    if (nums[end] < minvalue || nums[end] > maxvalue) {
                        currentSum = 0;
                        end += 1;
                        keepRange = 0;
                        start = end;
                    }
                    if (end< nums.length) {
                        currentSum += nums[end];
                        end += 1;
                        keepRange += 1;
                    }
                }else if (currentSum==target){
                        int startCase=start;
                        int endCase =end;
                        int newSum=currentSum;
                        int keepNewRange=keepRange;
                        while(startCase<=endCase && keepNewRange>=min){
                            if (newSum ==target){
                                res.add(new Result(startCase,endCase,getSub(nums,startCase,endCase)));
                            }
                            newSum-=nums[startCase];
                            keepNewRange-=1;
                            startCase+=1;
                        }
                        if (end< nums.length) {
                            currentSum += nums[end];
                            keepRange += 1;
                            end += 1;
                        }else{

                            break;
                        }
                }else{
                    currentSum-=nums[start];
                    keepRange-=1;
                    start+=1;
                }
            }
        }

        return res;
    }






    static int[] getSub(int[] nums, int start, int end) {
        int[] sub = new int[end - start ];
        for (int i = start; i <end; i++) {
            sub[i - start] = nums[i];
        }
        return sub;
    }

    static void printRes(ArrayList<Result> results) {
        for (Result res : results) {
            System.out.println("Subarrays found: [Start Index:" + res.start + ",End Index:" + (res.end-1) + "]");
            System.out.println("Subarray values: ");
            for (int val : res.subarray) {
                System.out.print(val + " ");
            }
            System.out.println("\n");
        }
    }

    static class Result {
        int start;
        int end;
        int[] subarray;

        Result(int start, int end, int[] subarray) {
            this.start = start;
            this.end = end;
            this.subarray = subarray;
        }
    }
}




