bad-dragon.com. IN SOA ns1.bad-dragon.com. admin.bad-dragon.com. (
         2
        3H
        1H
        1W
        1D )

; Name server
bad-dragon.com. IN NS ns1.bad-dragon.com.

;Address records
ns1.bad-dragon.com. IN A 10.39.167.113

bad-dragon.com. IN A 10.39.167.123

;Aliases
www IN CNAME bad-dragon.com.
ftp IN CNAME bad-dragon.com.
mail IN CNAME bad-dragon.com.
