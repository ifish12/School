#!/usr/bin/perl
use strict;
use warnings;
package CDMA;
use Data::Dumper;
my @codes=([1,1,1,1], [1,1,-1, -1], [1, -1, -1, 1], [1,-1, 1,-1]);

# ========================================================================
# testing
# ========================================================================

my @mux_numbers = mux("1101101","011","110100010", "00000000000010");
my @decoded = demux(@mux_numbers);

# Print mux numbers and decoded signals

print "===============MUX NUMBERS===============\n";
print join(",",@mux_numbers),"\n";
print "=========================================\n";
print "=============DECODED SIGNALS=============\n";
foreach my $n (@decoded){
        print join(", ", @$n), "\n";
}
print "=========================================\n";

# ========================================================================
# take multiple strings of ones and zeroes, and turn them into a
# single string of numbers, based on the predefined codes
# ========================================================================

sub mux {

# inputs
my @strings = ( @_ );

# bail out if we are trying to encode more datasets than we have code
if (@strings > @codes) {
die("You cannot encode more than: ".scalar(@codes));
}

# bail out if users are trying to encode non-binary like strings
foreach my $str (@strings) {
die ("must use strings of zeros and ones only")
unless $str=~/^[01]*$/;
}

# --------------------------------------------------------------------
# encode all strings into a single string ready for transmission
# --------------------------------------------------------------------

my @mux_numbers;
my @encoded;
my $count = 0;
my $muxCount = 0;
my @lengths;

foreach my $x (@strings){
        foreach my $c (split("", $x)){
                if($c == "1"){
                        push @encoded, encode($count, 1);
                }
                else {
                        push @encoded,  encode($count, -1);
                }
        }

foreach my $n (@encoded){
        $mux_numbers[$muxCount++] += $n;
}
push @lengths, $muxCount/@codes;
@encoded = ();
$muxCount = 0;
$count++;
}

push @mux_numbers, @lengths;
return @mux_numbers;
}

# ================================================================
# Get original signal from mux_numbers
# ================================================================

sub demux {

my $codeCount = 0;
my @demuxed;
my @dataSet;
my @bit;
my $bitCount;
my @muxNums = (@_);
while ($codeCount < @codes){

$bitCount = 0;
@dataSet = ();

# Find dot product for each data set (+tive = 1, -tive = 0)
foreach my $s (@muxNums){
        if($bitCount == @codes){
                if(dotProduct($codeCount, @bit) > 0){
                        push @dataSet, 1;
                }
                else{
                        push @dataSet, 0;
                }
                $bitCount = 0;
                @bit = ();
        }
 push @bit, $s;
        $bitCount++;
}

splice @dataSet, $bit[$codeCount];
$demuxed[$codeCount++] = [ @dataSet ];
}

return @demuxed;
}

# ============================================================
# Compute the dot product of the bits against the codes
# ============================================================

sub dotProduct {

my @bits;
my $code = shift;
my $decode;

for (my $i=0; $i < @codes; $i++){
        $bits[$i] = shift;
}

for (my $count=0; $count < @codes; $count++){
        $decode += $bits[$count] * $codes[$code][$count];
}

return $decode;
}
# ===========================================================
# Encode the signal string
# ===========================================================

sub encode {

my $pos = shift;
my $sign = shift;
my @coded;

foreach my $z ($codes[$pos]){
        foreach my $t (@$z){
                push @coded, $sign * $t;
        }
}

return @coded;
}
