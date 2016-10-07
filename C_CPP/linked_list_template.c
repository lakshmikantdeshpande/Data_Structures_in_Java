
// Singly Linked List using C
// 26 September 2016
// Lakshmikant A. Deshpande

#include <stdio.h>
#include <stdlib.h>

typedef struct node
{
  int data;
  struct node * next;
}node;

node * getnode(int data)
{
  node * temp = (node *)malloc(sizeof(node));
  temp -> data = data;
  temp -> next = NULL;
  return temp;
}


int main()
{
  int choice;
  node *head = getnode(0);
  while(1)
  {
    puts("\n\tMenu");
    puts(" 1 Insert at the beginning");
    puts(" 2 Insert at a position");
    puts(" 3 Insert a node at the end");
    puts(" 4 Display the linked list");
    puts(" 5 Length of the linked list");
    puts(" 6 Delete from the beginning");
    puts(" 7 Delete from a position");
    puts(" 8 Delete from the end");
    puts(" 9 Delete the linked list");
    puts("** Quit");
    printf("** Enter your choice: ");

    scanf("%d", &choice);
    switch (choice) {
      case 1:
        beginning_insert(&head);
        break;
      case 2:
        position_insert(&head);
        break;
      case 3:
        end_insert(head);
        break;
      case 4:
        display(head);
        break;
      case 5:
        printf("\nThe length of the linked list is %d \n\n", length(head));
        break;
      case 6:
        delete_beginning(&head);
        break;
      case 7:
        delete_position(&head);
        break;
      case 8:
        if (head == NULL)
          puts("Linked list is empty");
        else if (head -> next == NULL)
          head = NULL;
        else
          delete_end(head);
        break;
      case 9:
        delete_linked_list(&head);
        break;
      default:
        if (head != NULL)
          free(head);
        exit(0);
    }
  }
}
