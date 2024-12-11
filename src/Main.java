import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        int[] a = {-3,-1,-10,-9};

        ArrayList<Result> results = findSubs(a, -20, 1,4 , -1, 100);
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
            System.out.println("hello");
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




