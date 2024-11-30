Select e.name As name 
From Employee e
Join
    (Select managerId, COUNT(*)AS direct_reports
     From 
        Employee 
                Where managerId is NOT NULL
                Group by managerId Having COUNT(*)>=5)m
                ON e.id = m.managerId;
