public class dogProblem {
    public static Dog [] largerThanFourNeighbours(Dog[]dogs){
        Dog[] returnDogs = new Dog[dogs.length];
        int cnt=0;

        for (int i = 0; i < returnDogs.length; i++) {
            if(biggestofFourNeighbour(dogs,i)){
                returnDogs[cnt] = dogs[i];
                cnt++;
            }
        }
        return returnDogs;
        }

    public static boolean biggestofFourNeighbour(Dog[] dogs, int index) {
        boolean biggestFlag = true;
        //只要当前尺寸比邻居的尺寸小的话，就是false
        for (int j = -2; j < 2; j++) {
            if (validIndex(dogs, index + j)) {
                if (dogs[index].size < dogs[index + j].size) {
                    biggestFlag = false;
                    return biggestFlag;
                }
            }
        }
        return biggestFlag;
    }

    public static boolean validIndex(Dog[]dog,int index){
        if (index<0){
            return false;
        } else if (index>=dog.length) {
            return false;
        }
        return true;
    }
}

