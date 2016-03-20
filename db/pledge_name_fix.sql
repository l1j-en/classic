# First run the following command to see if there are any naming conflicts!
# This will return anyone that would conflict with another pledge if the spaces
# were to be removed from its name. You will need to rename it!
SELECT * FROM clan_data WHERE clan_name LIKE '% %' AND replace(clan_name, ' ','') IN (SELECT clan_name FROM clan_data);

#To rename any of the pledges found in the query above, run the 3 queries below
# UPDATE clan_warehouse SET clan_name = 'new name' WHERE clan_name = 'old name';
# UPDATE characters SET Clanname = 'new name' WHERE clan_name = 'old name';
# UPDATE clan_data SET clan_name = 'new name' WHERE clan_name = 'old name';

# Once any conflicts have been resolved, run the queries below
#UPDATE clan_warehouse SET clan_name = replace(clan_name,' ','');
#UPDATE characters SET Clanname = replace(Clanname,' ','');
#UPDATE clan_data SET clan_name = replace(clan_name,' ','');