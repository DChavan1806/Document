select * from test.boxes;

-- Query to find the all parent of a given child box

WITH RECURSIVE ParentCTE AS (
    SELECT id, parent_id, name
    FROM boxes
    WHERE id = 5  -- Replace with the child box ID

    UNION ALL

    SELECT b.id, b.parent_id, b.name
    FROM boxes b
    INNER JOIN ParentCTE p ON b.id = p.parent_id
)
SELECT * FROM ParentCTE WHERE parent_id IS NOT NULL;  -- Filters out the root


-- Query to find the only root from a given child box

WITH RECURSIVE ParentCTE AS (
    
    SELECT id, parent_id, name
    FROM boxes
    WHERE id = 5  

    UNION ALL


    SELECT b.id, b.parent_id, b.name
    FROM boxes b
    INNER JOIN ParentCTE p ON b.id = p.parent_id
)

SELECT * FROM ParentCTE WHERE parent_id IS NULL;

-- Query to Count All Children for Each Parent
WITH RECURSIVE DescendantCTE AS (
    SELECT id AS parent_id, id AS child_id
    FROM boxes

    UNION ALL


    SELECT p.parent_id, b.id AS child_id
    FROM boxes b
    INNER JOIN DescendantCTE p ON b.parent_id = p.child_id
)

-- Count the number of children for each parent
SELECT parent_id, COUNT(child_id) AS total_children
FROM DescendantCTE
WHERE parent_id != child_id  -- Exclude the parent itself
GROUP BY parent_id;


WITH recursive parent as (
	select id, parent_id, name 
    from boxes
	where id = 5
    
    union all
    
    select c.id, c.parent_id, c.name 
    from 
      boxes c
    join 
       parent p on p.parent_id = c.id
)

select * from parent p where p.parent_id is null



