
// This example creates a TCP socket and binds it to a server address and port.
// It then listens for incoming connections and accepts one when it arrives. 
// Finally, it reads and writes data over the socket and closes the socket
// 	when it finished


#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>

int main()
{
    // Create a socket
    int sockfd = socket(AF_INET, SOCK_STREAM, 0);
    if (sockfd < 0) {
        perror("Error creating socket");
        exit(1);
    }

    // Set up the server address and port
    struct sockaddr_in server_addr;
    memset(&server_addr, 0, sizeof(server_addr));
    server_addr.sin_family = AF_INET;
    server_addr.sin_port = htons(3500);
    server_addr.sin_addr.s_addr = INADDR_ANY;

    // Bind the socket to the server address and port
    if (bind(sockfd, (struct sockaddr*) &server_addr, sizeof(server_addr)) < 0) {
        perror("Error binding socket");
        exit(1);
    }

    // Listen for incoming connections
    if (listen(sockfd, 5) < 0) {
        perror("Error listening for incoming connections");
        exit(1);
    }

    // Accept an incoming connection
    struct sockaddr_in client_addr;
    socklen_t client_addr_len = sizeof(client_addr);
    int client_sockfd = accept(sockfd, (struct sockaddr*) &client_addr, &client_addr_len);
    if (client_sockfd < 0) {
        perror("Error accepting incoming connection");
        exit(1);
    }

    // Read and write data over the socket
    // ...

    // Close the sockets
    close(client_sockfd);
    close(sockfd);

    return 0;
}
