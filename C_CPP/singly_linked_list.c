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

void beginning_insert(node ** head)
{
  if (head == NULL)
  {
    puts("Linked list is empty!");
    return;
  }
  int data;
  printf("Enter data: ");
  scanf("%d", &data);
  node * temp = getnode(data);
  // new node's next is now head, and head is the new node
  temp -> next = *head;
  *head = temp;
  puts("Node has been inserted at the beginning successfully");
}

void position_insert(node ** head)
{
  int data, position, k = 1;
  node *p, *q;
  if (head == NULL)
  {
    puts("Linked list is empty!");
    return;
  }
  p = *head;
  printf("Enter data: ");
  scanf("%d", &data);
  printf("\nEnter position: ");
  scanf("%d", &position);
  if (position <= 0)
  {
    puts("Invalid position");
    return;
  }
  if (position == 1)
  {
    node * temp = getnode(data);
    // new node's next is now head, and head is the new node
    temp -> next = *head;
    *head = temp;
    return;
  }

  while (p != NULL && k < position)
  {
    k++;
    q = p;
    p = p -> next;
  }
  if (k == position)
  {
    node * temp = getnode(data);
    q -> next = temp;
    temp -> next = p;
  }
  else
    puts("Invalid position");
}

void end_insert(node * head)
{
  int data;
  if (head == NULL)
  {
    puts("Linked list is empty!");
    return;
  }
  // traverse to the end of the list
  while (head -> next != NULL)
    head = head -> next;

  printf("Enter data: ");
  scanf("%d", &data);
  node * temp = getnode(data);
  head -> next = temp;
  puts("Node has been inserted at the end successfully");
}

void display(node * head)
{
  if (head == NULL)
  {
    puts("Linked list is empty!");
    return;
  }
  puts("");
  while (head != NULL)
  {
      printf("%d -> ", head -> data);
      head = head -> next;
  }
  printf("\n\n");
}

int length(node * head)
{
  if (head == NULL)
  {
    puts("Linked list is empty!");
    return 0;
  }

  int len = 0;
  while (head != 0)
  {
    len++;
    head = head -> next;
  }
  return len;
}

void delete_beginning(node ** head)
{
  if (head == NULL)
  {
    puts("Linked list is empty!");
    return;
  }
  node *p = *head;
  *head = (*head) -> next;
  free(p);
  return;
}

void delete_position(node ** head)
{
  int position, k = 1;
  node *p, *q;
  if (head == NULL)
  {
    puts("Linked list is empty!");
    return;
  }
  printf("Enter position: ");
  scanf("%d", &position);
  if (position <= 0)
  {
    puts("\nInvalid position");
    return;
  }
  if (position == 1)
  {
    p = *head;
    *head = (*head) -> next;
    free(p);
    return;
  }
  else
  {
    p = *head;
    while (p != NULL && k < position)
    {
      k++;
      q = p;
      p = p -> next;
    }
    if (p == NULL || k != position)
    {
      puts("Invalid position");
      return;
    }
    else
    {
      q -> next = p -> next;
      free(p);
      puts("Node deleted successfully");
    }
  }
}

void delete_end(node * head)
{
  node *p, *q;
  if (head == NULL)
  {
    puts("Linked list is empty!");
    return;
  }
  p = head;
  while (p -> next != NULL)
  {
    q = p;
    p = p -> next;
  }
  q -> next = NULL;
  free(p);
}

void delete_linked_list(node ** head)
{
  node *p = *head, *q;
  while (p != NULL)
  {
    q = p -> next;
    free (p);
    p = q;
  }
  *head = NULL;
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
