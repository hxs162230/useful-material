353. Design Snake Game

Design a Snake game that is played on a device with screen size = width x height. 

Play the game online if you are not familiar with the game.

The snake is initially positioned at the top left corner (0,0) with length = 1 unit.

You are given a list of food's positions in row-column order. When a snake eats the food, 

its length and the game's score both increase by 1.

Each food appears one by one on the screen. 

For example, the second food will not appear until the first food was eaten by the snake.

When a food does appear on the screen, it is guaranteed that it will not appear on a block occupied by the snake.

Example:

Given width = 3, height = 2, and food = [[1,2],[0,1]].

Snake snake = new Snake(width, height, food);

Initially the snake appears at position (0,0) and the food at (1,2).

|S| | |
| | |F|

snake.move("R"); -> Returns 0

| |S| |
| | |F|

snake.move("D"); -> Returns 0

| | | |
| |S|F|

snake.move("R"); -> Returns 1 (Snake eats the first food and right after that, the second food appears at (0,1) )

| |F| |
| |S|S|

snake.move("U"); -> Returns 1

| |F|S|
| | |S|

snake.move("L"); -> Returns 2 (Snake eats the second food)

| |S|S|
| | |S|

snake.move("U"); -> Returns -1 (Game over because snake collides with border)

感觉最近LeetCode经常出一些design类的题目啊，难道算法类的题目都出完了吗，
这道题让我们设计一个贪吃蛇的游戏，这是个简化版的，但是游戏规则还是保持不变，
蛇可以往上下左右四个方向走，吃到食物就会变长1个，如果碰到墙壁或者自己的躯体，
游戏就会结束。我们需要一个一维数组来保存蛇身的位置，由于蛇移动的过程的蛇头向前走一步，
蛇尾也跟着往前，中间的躯体还在原来的位置，所以移动的结果就是，蛇头变到新位置，
去掉蛇尾的位置即可。需要注意的是去掉蛇尾的位置是在检测和蛇身的碰撞之前还是之后，
如果是之后则无法通过这个test case：[[3,3,[[2,0],[0,0]]],["D"],["D"],["U"]]，
如果是之前就没有问题了，检测蛇头和蛇身是否碰撞使用的是count(snake.begin(), snake.end(), 
    head)，
总体来说不算一道难题，参见代码如下：

class SnakeGame {

    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.score = 0;
        this.food = new LinkedList<>();
        for(int[] a:food){
            this.food.add(a);
            //System.out.print(a[0]+"@"+a[1]);
        }
        this.snake = new LinkedList<int[]>();
        this.snake.add(new int[]{0,0});
        
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        int[] head = this.snake.get(0);
        int PosX = head[0];
        int PosY = head[1];

        int[] tail = this.snake.get(this.snake.size()-1);
        this.snake.remove(this.snake.size()-1);
        
        if(direction.equals("U")) --PosX;
        else if(direction.equals("D")) ++PosX;
        else if(direction.equals("L")) --PosY;
        else ++PosY;
        
        if(PosX<0||PosX>=height||PosY<0||PosY>=width){
            return -1;
        }
        for(int i=this.snake.size()-1;i>0;i--){
            if(PosX==this.snake.get(i)[0]&&PosY==this.snake.get(i)[1]){
                return -1;
            }
        }
        this.snake.add(0,new int[]{PosX,PosY});
        if(!food.isEmpty()&&(PosX==this.food.get(0)[0]&&PosY==this.food.get(0)[1])){
            this.food.pollFirst();
            this.snake.add(tail);
            ++this.score;
        }
        return this.score;
    }
    private int width,height,score=0;
    private LinkedList<int[]> food,snake;
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */

