import sqlite3
from datetime import date

swim_sets = [
	{
        "id": 1,
        "repLength": 150,
        "repCount": 6,
        "name": "6x150s free",
        "description": "6 reps of 150 yards of freestyle",
        "labels": "Full Body,Endurance"
    },
    {
        "id": 2,
        "repLength": 25,
        "repCount": 10,
        "name": "10x25s breast kick",
        "description": "10 reps of 25 yards of breaststroke kick with board",
        "labels": "Legs"
    },
    {
        "id": 3,
        "repLength": 25,
        "repCount": 10,
        "name": "10x25s free kick",
        "description": "10 reps of 25 yards of freestyle kick with board",
        "labels": "Legs"
    },
    {
        "id": 4,
        "repLength": 25,
        "repCount": 10,
        "name": "10x25s fly kick",
        "description": "10 reps of 25 yards of butterfly kick without board",
        "labels": "Legs,Breathing"
    },
    {
        "id": 5,
        "repLength": 50,
        "repCount": 10,
        "name": "10x50s breast kick",
        "description": "10 reps of 50 yards of breaststroke kick with board",
        "labels": "Legs"
    },
    {
        "id": 6,
        "repLength": 50,
        "repCount": 10,
        "name": "10x50s free kick",
        "description": "10 reps of 50 yards of freestyle kick with board",
        "labels": "Legs"
    },
    {
        "id": 7,
        "repLength": 50,
        "repCount": 10,
        "name": "10x50s fly kick",
        "description": "10 reps of 50 yards of butterfly kick without board",
        "labels": "Legs,Breathing"
    },
    {
        "id": 8,
        "repLength": 150,
        "repCount": 6,
        "name": "6x150s pull",
        "description": "6 reps of 150 yards of freestyle with pull bouy",
        "labels": "Arms,Endurance"
    },
    {
        "id": 9,
        "repLength": 200,
        "repCount": 5,
        "name": "5x200s pull",
        "description": "5 reps of 200 yards of freestyle with pull bouy",
        "labels": "Arms,Endurance"
    },
    {
        "id": 10,
        "repLength": 200,
        "repCount": 4,
        "name": "4x200s free",
        "description": "4 reps of 200 yards of freestyle",
        "labels": "Full Body,Endurance"
    },
    {
        "id": 11,
        "repLength": 100,
        "repCount": 10,
        "name": "10x100s free",
        "description": "10 reps of 100 yards of freestyle",
        "labels": "Full Body"
    },
    {
        "id": 12,
        "repLength": 100,
        "repCount": 5,
        "name": "5x100s free",
        "description": "5 reps of 100 yards of freestyle. This is a good warm up set.",
        "labels": "Full Body,Warmup"
    },
    {
        "id": 13,
        "repLength": 50,
        "repCount": 10,
        "name": "10x50s free",
        "description": "10 reps of 50 yards of freestyle. This is a good warm up set.",
        "labels": "Full Body,Warmup"
    },
    {
        "id": 14,
        "repLength": 100,
        "repCount": 5,
        "name": "5x100s IM",
        "description": "5 reps of 100 yards of IM. This means 25 yards of butterfly, then back stroke, then breast stroke, then freestyle. This is a good warm up set.",
        "labels": "Full Body,Endurance,Warmup"
    },
    {
        "id": 15,
        "repLength": 100,
        "repCount": 8,
        "name": "8x100s IM",
        "description": "8 reps of 100 yards of IM. This means 25 yards of butterfly, then back stroke, then breast stroke, then freestyle.",
        "labels": "Full Body,Endurance"
    },
    {
        "id": 16,
        "repLength": 50,
        "repCount": 10,
        "name": "10x50s breast stroke",
        "description": "10 reps of 50 yards of breast stroke.",
        "labels": "Arms,Legs"
    },
    {
        "id": 17,
        "repLength": 50,
        "repCount": 10,
        "name": "10x50s fly",
        "description": "10 reps of 50 yards of butterfly.",
        "labels": "Arms,Legs"
    },
    {
        "id": 18,
        "repLength": 75,
        "repCount": 10,
        "name": "10x75s fly",
        "description": "10 reps of 75 yards of butterfly.",
        "labels": "Arms,Full Body"
    },
    {
        "id": 19,
        "repLength": 100,
        "repCount": 10,
        "name": "10x100s fly",
        "description": "10 reps of 100 yards of butterfly.",
        "labels": "Arms,Full Body,Endurance"
    },
    {
        "id": 20,
        "repLength": 75,
        "repCount": 10,
        "name": "10x75s free, no turn breathing",
        "description": "10 reps of 75 yards of freestyle. No breathing between the flags and the wall.",
        "labels": "Full Body,Breathing"
    },
    {
        "id": 21,
        "repLength": 25,
        "repCount": 4,
        "name": "4x25s free, one-breath",
        "description": "4 reps of 25 yards of freestyle. One breath or no breath.",
        "labels": "Breathing,Cooldown"
    },
    {
        "id": 22,
        "repLength": 50,
        "repCount": 10,
        "name": "10x50s free, breath crescendo",
        "description": "10 reps of 50 yards of freestyle. Breathing pattern will be breathing every 3-5-7-9 then the 5th and 6th 50 yards are 3 (max) breath 50s. Then descend back down in the pattern of 9-7-5-3.",
        "labels": "Breathing"
    },
    {
        "id": 23,
        "repLength": 50,
        "repCount": 10,
        "name": "10x50s free sprint",
        "description": "10 reps of 50 yards of freestyle. This is a sprint, rep does not count unless it is below 35 seconds. The time between the start of one rep to the next shall not exceed 2:30.",
        "labels": "Sprint"
    },
    {
        "id": 24,
        "repLength": 50,
        "repCount": 10,
        "name": "10x50s free sprint",
        "description": "10 reps of 50 yards of freestyle. Only 3 breaths are allowed per 50.",
        "labels": "Breathing"
    },
    {
        "id": 25,
        "repLength": 25,
        "repCount": 10,
        "name": "10x25s no breath",
        "description": "10 reps of 25 yards of freestyle. No breaths.",
        "labels": "Breathing"
    },
    {
        "id": 26,
        "repLength": 50,
        "repCount": 10,
        "name": "10x50s breast kick alternate legs",
        "description": "10 reps of 50 yards of breast stroke kick. Only use one leg per lap, each lap, change the leg being used.",
        "labels": "Legs"
    },
    {
        "id": 27,
        "repLength": 100,
        "repCount": 10,
        "name": "10x100s IM",
        "description": "10 reps of 100 yards of IM. This means 25 yards of butterfly, then back stroke, then breast stroke, then freestyle. This is a good warm up set.",
        "labels": "Full Body,Endurance,Warmup"
    },
]

set_occurences = [
    {
        "id": 1,
        "dateScheduled": date(year=2024, month=6, day=3),
        "order": 1,
        "scheduledSetId": 12
    },
    {
        "id": 2,
        "dateScheduled": date(year=2024, month=6, day=3),
        "order": 2,
        "scheduledSetId": 1
    },
    {
        "id": 3,
        "dateScheduled": date(year=2024, month=6, day=3),
        "order": 3,
        "scheduledSetId": 3
    },
    {
        "id": 4,
        "dateScheduled": date(year=2024, month=6, day=3),
        "order": 4,
        "scheduledSetId": 21
    },
    {
        "id": 5,
        "dateScheduled": date(year=2024, month=6, day=4),
        "order": 1,
        "scheduledSetId": 12
    },
    {
        "id": 6,
        "dateScheduled": date(year=2024, month=6, day=4),
        "order": 2,
        "scheduledSetId": 27
    },
    {
        "id": 7,
        "dateScheduled": date(year=2024, month=6, day=4),
        "order": 3,
        "scheduledSetId": 21
    },
    {
        "id": 8,
        "dateScheduled": date(year=2024, month=6, day=5),
        "order": 1,
        "scheduledSetId": 12
    },
    {
        "id": 9,
        "dateScheduled": date(year=2024, month=6, day=5),
        "order": 2,
        "scheduledSetId": 2
    },
    {
        "id": 10,
        "dateScheduled": date(year=2024, month=6, day=5),
        "order": 3,
        "scheduledSetId": 20
    },
    {
        "id": 11,
        "dateScheduled": date(year=2024, month=6, day=5),
        "order": 4,
        "scheduledSetId": 21
    },
    {
        "id": 12,
        "dateScheduled": date(year=2024, month=6, day=7),
        "order": 1,
        "scheduledSetId": 12
    },
    {
        "id": 13,
        "dateScheduled": date(year=2024, month=6, day=7),
        "order": 2,
        "scheduledSetId": 3
    },
    {
        "id": 14,
        "dateScheduled": date(year=2024, month=6, day=7),
        "order": 3,
        "scheduledSetId": 9
    },
    {
        "id": 15,
        "dateScheduled": date(year=2024, month=6, day=7),
        "order": 4,
        "scheduledSetId": 20
    }
]

conn = sqlite3.connect('C:/Users/andre/Desktop/Stuff/sqlite-tools-win-x64-3460000/swim-set.db')
cursor = conn.cursor()

for entry in swim_sets:
    # Insert the swim sets
    cursor.execute(
        'INSERT INTO Swim_Set (ID, REP_LENGTH, REP_COUNT, NAME, DESCRIPTION, LABEL_TEXT) VALUES (?, ?, ?, ?, ?, ?);', 
        (entry["id"],
        entry["repLength"],
        entry["repCount"],
        entry["name"],
        entry["description"],
        entry["labels"])
    )
    conn.commit()

for entry in set_occurences:
    #date_scheduled date, 
    #set_order integer, 
    #id bigint not null, 
    #scheduled_set_id bigint,
    cursor.execute(
        """
        INSERT INTO Scheduled_Set
        (ID, Date_Scheduled, Set_Order, Scheduled_Set_Id)
        VALUES
        (?, ?, ?, ?)
        """,
        (
            entry["id"], str(entry["dateScheduled"]), 
            entry["order"], entry["scheduledSetId"]
        )
    )
    conn.commit()

conn.close()
