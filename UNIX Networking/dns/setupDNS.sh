#!/bin/bash

# Created by Geoff Shapiro & Ryan Carrier

set -u

if [[ $# -lt 2 ]]
then
        echo "Must send a domain and an IP";
        exit 1;
fi

domain=$1;
ip=$2;

grep "zone \"$domain" /etc/named.conf > /dev/null; # checking if we have this domain already created
if [[ $? -eq 0 ]]
then
        echo "Domain already exists.";
        exit 2;
fi

echo -e "zone \"$domain\" in {
         type master;
         file \"$domain\";
};" >> /etc/named.conf; # Adding the new domain zone to config file

echo -e "$domain. IN SOA ns1.bad-dragon.com. admin.bad-dragon.com. (
        2
        3H
        1H
        1W
        1D )\n
$domain. IN NS ns1.bad-dragon.com.\n
ns1.bad-dragon.com. IN A 10.39.167.113\n
$domain. IN A $ip\n
www IN CNAME $domain.
ftp IN CNAME $domain.
mail IN CNAME $domain." > /var/named/$domain;

systemctl stop named;
systemctl start named;


