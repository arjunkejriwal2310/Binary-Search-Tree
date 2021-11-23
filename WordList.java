public class WordList
{
    public static void main(String[] args)
    {
        RunTimer timer1 = new RunTimer();
        RunTimer timer2 = new RunTimer();

        WordReader wr1 = new WordReader("C:\\Users\\Arjun Kejriwal\\IdeaProjects\\Assignment 2 (COSC-211)\\src\\MobyDick.txt");
        WordReader wr2 = new WordReader("C:\\Users\\Arjun Kejriwal\\IdeaProjects\\Assignment 2 (COSC-211)\\src\\MobyDick.txt");

        SimpleUSet<String> ArraySet = new ArraySimpleSSet<String>();
        SimpleUSet<String> BSTSet = new BinarySearchTree<String>();
        ArraySimpleSSet<String> ArraySetAlt = (ArraySimpleSSet) ArraySet;
        BinarySearchTree<String> BSTSetAlt = (BinarySearchTree) BSTSet;

        System.out.println(" ");
        System.out.println("----------------------------------------------------------");
        System.out.println(" ");

        String word2 = wr2.nextWord();
        int b = 0;

        while(word2 != null)
        {
            timer2.start();
            BSTSet.add(word2);
            word2 = wr2.nextWord();

            b++;
            if(b % 5000 == 0)
            {
                System.out.println(timer2.getElapsedMillis());
            }
            timer2.stop();
        }

    }
}
