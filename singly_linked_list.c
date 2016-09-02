// Singly Linked List using C
// 1 September 2016
// Lakshmikant A. Deshpande

#include <stdio.h>
#include <stdlib.h>

typedef struct node
{
  int data;
  struct node * next;
}node;

int length(node * head)
{
  int counter;
  while (head != NULL)
  {
    counter ++;
    head = head -> next;
  }
  return counter;
  // free(head);
}

void display(node * head)
{
  while (head != NULL)
  {
    printf("%d ->", head -> data);
    head = head -> next;
  }
  puts(""); // for newline
}

void addToTheBeginning(node ** head, int data)
{
  node * temp = (node *)malloc(sizeof(node));
  temp -> data = data;
  temp -> next = *head;
  *head = temp;
}

void addToTheEnd(node * head, int data)
{
  node * temp = (node *)malloc(sizeof(node));
  temp -> data = data;
  node * t = head;
  while (t -> next != NULL)
  {
    t = t -> next;
  }
  t -> next = temp;
}

// TODO
void addInTheMiddle(node * head, int data, int position)
{
    node * temp = (node *)malloc(sizeof(node));
    temp -> data = data;

    int k = 1;
    node * p = head, *q;
    while (p != NULL && k < position)
    {
      q = p;
      p = p -> next;
      k++;
    }
    if (k == position)
    {
      temp -> next = q -> next;
      q -> next = temp;
    }
    else
      puts("Invalid position mate !");
}

int main()
{
  // create and initialize head node
  node * head = (node *)malloc(sizeof(node));
  head -> next = NULL;
  head -> data = 0;

  printf("The length is %d\n", length(head));
  addToTheBeginning(&head, -1);
  addInTheMiddle(head, 1, 1);
  display(head);
  free(head);
}
