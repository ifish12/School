use strict;
use warnings;
use IO::Socket;

my $host = "127.0.0.1";
my $port = 192392;

# Connect to server
my $socket = IO::Socket::INET->new (
        Proto=>'tcp',
        PeerAddr=>$host,
        PeerPort=>$port)
or die "Cannot connect\n";

# Initialize Variables
my $username = "";
my $line = "";
my $response = "";
my $text = "";
my $tmp = "";

# Set Username
print "What's your username: ";
$username = <>;
chomp $username;
print "\nUsername " . $username . " set! \n\n";

# While user doesn't quit
# Or kicked from server
# Keep listening and sending messages
while ($line ne "q" && $tmp ne "bye") {
        
        # User listening for a response form server
        # Keep listening until recieving a '~'
        do{
                # Get Msg
                $response = <$socket>;
                
                # Print if not tilde
                $tmp = $response;
                chomp $tmp;
                if($tmp ne "~"){
                        print $response;
                }
                
        } while ($tmp ne "~" && $tmp ne "bye");
        
        # Kicked by server? 
        if($tmp ne "bye"){
                # User writing message
                # Keep writing until sending a single '~' or 'q' character
                do{
                        # Multiline Prefix 
                        print "<" . $username . "> ";
                        
                        # Get line from client
                        $line = <>;
                        chomp $line;
                        
                        #Append to text
                        $text .= "\n" . "<" . $username . "> " . $line;
                } while ($line ne "~" && $line ne "q");
                
                # Send message to server
                $text = $text . "\n";
                print $socket $text;
                
                # Clear buffers
                $text = '';
                $response = '';
        }
}
