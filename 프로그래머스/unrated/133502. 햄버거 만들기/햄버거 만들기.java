import java.util.Stack;

class Solution {
        final static int[] recipe = new int[]{1, 2, 3, 1};
    final Stack<Integer> ingredientStack = new Stack<>();
    
    public int solution(int[] ingredient) {
        int answer = 0, recipeIndex = 0;
        
        for(int i : ingredient) {
            if(recipe[recipeIndex] == i) {
                ingredientStack.push(recipe[recipeIndex++]);
            } else if (recipe[0] == i) {
                ingredientStack.push(i);
                recipeIndex = 1;
            } else {
                if(!ingredientStack.empty()) {
                    ingredientStack.clear();
                }
                recipeIndex = 0;
            }
            if(recipeIndex >= recipe.length) {
                makeHamburger();
                recipeIndex = findNextRecipeIndex();
                answer += 1;
            }
        }
        return answer;
    }
    
    private void makeHamburger() {
        for(int i = 0; i < recipe.length; i++) {
            ingredientStack.pop();
        }
    }
    
    private int findNextRecipeIndex() {
        if(ingredientStack.empty()) {
            return 0;
        }
        
        int ingredient = ingredientStack.peek();
        
        for(int i = 0; i < recipe.length; i++) {
            if(recipe[i] == ingredient) {
                return i + 1;
            }
        }
        
        return -1; // Error : Unknown ingredient
    }
}