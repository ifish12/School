use warnings;
use strict;
use IO::Socket;

# Steup Socket
my $socket = new IO::Socket::INET
        (Listen => 2,
         LocalPort => 192392 )
or die ("Cannot create socket \n
        $!\n
        $@\n");
        
while(1){
        # Initialize Variables
        my $text = "";
        my $clientSpeaking = 1;
        
        # Connect User 1
        my $client1 = connectClient();
        print $client1 "<Server> Waiting for another user...\n";
        
        # Connect User 2
        my $client2 = connectClient();
        print $client2 "<Server> Waiting for response from other User\n\n";
        
        # Notify User 1 & send prompt to send message
        print $client1 "<Server> Found a user! Speak!\n\n";
        print $client1 "~\n";
             
        
        # Chat loop continues until 2 disconnects
        while(defined $client1 && defined $client2){
                my $text = "";
                
                # Who's turn is it to speak?
                if($clientSpeaking eq 1){
                        # Get & Send Msg
                        $client1 = getAndSend($client1, $client2);
                        # Check for & handle disconnect
                        unless(defined $client1){
                                $client1 = disconnection($client1, $client2);
                        }

                        # Rotate Speaker
                        $clientSpeaking = 2;
                }
                else{
                        # Get & Send Msg
                        $client2 = getAndSend($client2, $client1);
                        
                        # Check for & handle disconnect
                        unless(defined $client2){
                                $client2 = disconnection($client2, $client1);
                        }
                        # Rotate Speaker
                        $clientSpeaking = 1;
                }
        
        }
        
        #Cleanup for fresh connection
        undef $client1;
        undef $client2;
}

#----------------------------------------------------------
# function:    welcome
# description: Welcome a user to the char server
# arguments:   Client
#----------------------------------------------------------

sub welcome{
        my $client = shift;
        print $client "====================================== \n";
        print $client "        Welcome to the Server!         \n";      
        print $client "====================================== \n";
        print $client "To send you message to the other user, \n";
        print $client "enter a '~' on a new line. Similarly,  \n";
        print $client "you can send a 'q' to quit the server. \n";
        print $client "====================================== \n";
        print $client "\n";
}

#----------------------------------------------------------
# function:    getMessage
# description: Retrieves message from client
# arguments:   Client
#----------------------------------------------------------

sub getMessage{
        my $client = shift;
        my $text   = '';

        while( my $line = <$client>) {
                last if $line =~/~/;
                $text.=$line;
        }
        
        chomp $text;
        return $text;
}

#----------------------------------------------------------
# function:    getAndSend
# description: Retrieves message from 1st passed user and
#              sends it to 2nd passed user
# arguments:   Client Sending, Client Recieving
#----------------------------------------------------------
sub getAndSend{
        my $sender   = shift;
        my $reciever = shift;
        my $lastChar = undef;
        my $text = "";
        
        # Get msg from sender
        $text = getMessage($sender);
        
        #Send msg to retriever
        print $reciever "$text \n";
              
        # Did sender disconnect?
        $lastChar = substr $text, -1;
        if($lastChar eq 'q'){
                # Disconnect sender
                $sender->close;
                undef $sender;
                
                # Alert reciever
                print $reciever "\n<Server> Other user has disconnected! \n";
                return $sender;
        }
        
        print $reciever "~\n";
        return $sender;
}

#----------------------------------------------------------
# function:    disconnect
# description: Disconnects sent user and waits for a new
#              user
# arguments:   Disconnected Client, Remaining Client
#----------------------------------------------------------
sub disconnection{
        my $disconnectedClient = shift;
        my $remainingClient    = shift;
        my $text     = "";
        my $firstChar = "";
        
        
        # Alert Remaining Client
        print $remainingClient "<Server> Remain connected [y/n]: \n";
        print $remainingClient "~\n";
        

        $text = getMessage($remainingClient);
        
        if($text =~ /y$/){
                print $remainingClient "<Server> Waiting for another user! \n";
                # Get New Connection
                $disconnectedClient = connectClient();
                
                # Notify both users
                print $remainingClient "<Server> User connected! \n\n";
                print $remainingClient "~\n";
                print $disconnectedClient "<Server> Waiting for response for other user...\n";
        }
        else{
                print $remainingClient "bye";
                $remainingClient->close;       
        }
        
        return $disconnectedClient;
}

#----------------------------------------------------------
# function:    connectClient
# description: Returns a connected user
#----------------------------------------------------------
sub connectClient{
        my $client = $socket->accept;
        welcome ($client);
        return $client;
}