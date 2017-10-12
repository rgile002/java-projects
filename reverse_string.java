
//by Rolf Kinder Gilet

 String temp;
        //int StrLeng;
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter a String: ");
        temp = kb.nextLine();

        for (int i = temp.length()-1; i > -1; i = i - 1) {
            System.out.print(temp.charAt(i));
        }
