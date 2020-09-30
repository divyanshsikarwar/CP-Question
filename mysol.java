import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Solution {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static class node {
		int box_number =101;
		int throw_count = 101;



		boolean visited = false;

		List<node> can_go = new ArrayList<node>();
		//node next=null;
		node snake_next = null;
		node ladder_next = null;
	}

	public static void main(String args[])throws IOException,NullPointerException{

		int test_case = Integer.parseInt(br.readLine());
		int result[] = new int[test_case];


		for(int i=0; i<test_case ;i++){
		node boxes[] = new node[101];


		//int throws_occured[] = new int [101];
		create_board(boxes);
		String snake_and_ladder = br.readLine();
		String quantity[] = snake_and_ladder.split("\\,");
		int ladder=Integer.parseInt(quantity[0]);
		int snakes=Integer.parseInt(quantity[1]);

		//System.out.println(ladder+"  "+snakes);
		place_ladders(boxes,ladder);
		spawn_snakes(boxes,snakes);
		prepare_can_go(boxes); //to prepapre remaining links
	/*	for(int p=1;p<101;p++){
			System.out.println(boxes[p].box_number);
			if(boxes[p].snake_next == null){}
			else {System.out.println("Snake to: "+boxes[p].snake_next.box_number);}
			if(boxes[p].ladder_next == null){}
			else {System.out.println("Ladder to: "+boxes[p].ladder_next.box_number);}
			System.out.println("****************************************************");
		}
		*/
		//now implement dijktra's algorithm for shortest path
		boxes[1].throw_count=0;
		node least_unvisited = boxes[1];
		while(least_unvisited.box_number!=101)
		{	

			if(!least_unvisited.can_go.isEmpty()){
				Iterator<node> iter = least_unvisited.can_go.iterator();
				while(iter.hasNext()){
				node n = (node)iter.next();
				if(n.throw_count > least_unvisited.throw_count+1){
				n.throw_count = least_unvisited.throw_count + 1;}
				}
			}

			if(least_unvisited.ladder_next!=null){
				if(least_unvisited.ladder_next.throw_count>least_unvisited.throw_count){
					least_unvisited.ladder_next.throw_count = least_unvisited.throw_count;
				}
			}
			if(least_unvisited.snake_next!=null){
				if(least_unvisited.snake_next.throw_count>least_unvisited.throw_count){
					least_unvisited.snake_next.throw_count = least_unvisited.throw_count;
				}
			}


			/*System.out.println(least_unvisited.box_number);
			if(least_unvisited.ladder_next == null){}
			else if(least_unvisited.ladder_next.throw_count>least_unvisited.throw_count+1 && least_unvisited.ladder_next.visited == false){
				least_unvisited.ladder_next.throw_count = least_unvisited.throw_count+1;
			}
			if(least_unvisited.snake_next == null){}
			else if(least_unvisited.snake_next.throw_count>least_unvisited.throw_count+1 && least_unvisited.snake_next.visited == false){
				least_unvisited.snake_next.throw_count = least_unvisited.throw_count +1;
			}*/
			if(least_unvisited.box_number<=94 && boxes[least_unvisited.box_number+6].throw_count>least_unvisited.throw_count+1 && boxes[least_unvisited.box_number+6].visited==false){
				boxes[least_unvisited.box_number+6].throw_count = least_unvisited.throw_count + 1;
			}

			if(least_unvisited.box_number > 94){
				int diff = 100-least_unvisited.box_number;
				if(boxes[least_unvisited.box_number+diff].throw_count>least_unvisited.throw_count+1 && boxes[least_unvisited.box_number+diff].visited==false){
					boxes[least_unvisited.box_number+diff].throw_count = least_unvisited.throw_count + 1;
				}

			}//>94

			least_unvisited.visited = true;
			least_unvisited = least_unvisited_finder(boxes);
		}//while
		result[i]=boxes[100].throw_count;
		}//test case

		for(int i = 0; i<test_case ; i++){
		System.out.println(result[i]);
		}
	}
	public static void prepare_can_go(node[] boxes){

		for(int i=1;i<101;i++){
			//if(boxes[i].ladder_next==null){}
			if(boxes[i].ladder_next != null){
				int d;
				if(i>7){d=i-6;}
				else {d=1;}
				for(int p = i-1;p>=d;p--){
					boxes[p].can_go.add(boxes[i].ladder_next);
				}
			}
		}

	}
	public static node least_unvisited_finder(node[] boxes){
		int min = 101;
		node least_and_unvisited = new node();
	    least_and_unvisited.box_number=101;
		for(int i=1;i<101;i++){
			if(boxes[i].throw_count<min && boxes[i].visited == false){
				min = boxes[i].throw_count;
				least_and_unvisited = boxes[i];
			}
		}


		return least_and_unvisited;
	}
	public static void create_board(node boxes[]){
		int num=1;
		while(num!=101){
			boxes[num]= new node();
			boxes[num].box_number = num;
			num++;
		}
	}

	public static void place_ladders(node boxes[],int ladder)throws IOException{
		String pairs = br.readLine();
		String split_pairs[] = pairs.split(" ");

		int l=0;
		while(l<ladder){
			String start_end[] = split_pairs[l].split("\\,");
			int start = Integer.parseInt(start_end[0]);
			int end = Integer.parseInt(start_end[1]);
			boxes[start].ladder_next = boxes[end];
			l++;
		}
	}//place_ladder
	public static void spawn_snakes(node boxes[],int snakes)throws IOException{
		String pairs = br.readLine();
		String split_pairs[] = pairs.split(" ");

		int s=0;
		while(s<snakes){
			String start_end[] = split_pairs[s].split("\\,");
			int start = Integer.parseInt(start_end[0]);
			int end = Integer.parseInt(start_end[1]);
			boxes[start].snake_next = boxes[end];
			s++;
		}
	}//spawn_snakes
}