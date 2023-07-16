INSERT INTO t_permission (role)
VALUES
    ('ROLE_USER'),
    ('ROLE_ADMIN');

INSERT INTO t_users (email, full_name, password)
VALUES
    ('ilyas@gmail.com', 'Ilyas User', '$2a$10$EdojOIvoKPLG0TyNcxOyR.A69iSvlKoJMDqhHOXUNMq0EGxe/H0Lu'),
    ('admin@mail.ru', 'Admin Admin', '$2a$10$XLr3lvaOKvz5VyKsEv/9C.8y/n47gxfzzNWkjWOFKZ9spOY.Hc2rq'),
    ('aisha@email.ru', 'Aisha Bolatova', '$2a$10$J4fRTgfhCU5u4KHsFXmXJOZj.6gTU624Ao4h6kXQCUwcdRMUPpNjC'),
    ('erik@gmail.com', 'Erik Erikov', '$2a$10$gRvFqjnHgE1jyrNFESgWiuaFsdN925fmDSfcaHbhiax03CIG/QcPO'),
    ('zhandos@gmail.com', 'Zhandos User', '$2a$10$t.EhsVgv6j.rZFbz6r507OOrc5PxszKZc0q1QObAFgtnC.Xyvz/qG');

INSERT INTO t_users_permissions (user_id, permissions_id)
VALUES
    (1,1),
    (1,2),
    (2,1),
    (2,2);

INSERT INTO categories (name) VALUES
      ('World'),
      ('Politics'),
      ('Opinion'),
      ('Health'),
      ('Style'),
      ('Travel'),
      ('Sports');

INSERT INTO posts (post_content, created_at, image_url, post_title, category_id)
VALUES
    (
           'Dozens of people have been injured in Russian shelling on a town in Ukraine''s Kharkiv region, according to the local authorities.

       “As of now, 38 people have been wounded in the shelling of Pervomaiskyi in Kharkiv region, including 12 children. The youngest is 3 months old, and medics provided him with first aid on the spot,” according to the Ukrainian Prosecutor General’s office.

       "The windows of 8 multi-story buildings in the town were damaged. In addition, 4 cars were on fire and 1 car was damaged," said the head of the Kharkiv regional military administration Oleg Sinegubov.

       Rescue workers are on the scene, according to the Interior Ministry of Ukraine.

       "Russians fired a high-explosive projectile," which caused several cars to catch on fire and caused damage to the high-rise buildings, according to Andriy Yermaak, the head of the Ukrainian presidential office.

       At least 16 flights to Moscow''s Vnukovo International Airport had been diverted on Tuesday, according to Russian state media and data from the official schedule on the airport website.

       Some flights were rerouted "for security reasons" due to the "attempted drone attack by Ukrainian drones" in Russia''s capital, Moscow Mayor Sergey Sobyanin said on Telegram.

       Six of the planes were diverted due to "technical issues," according to a statement on the website of Russia''s Federal Air Transport Agency, also known as Rosaviatsiya.

       Flight restrictions at Vnukovo were in place from 5:10 a.m. to 8:00 a.m. local time, according to the state news agency TASS.

       Flights impacted – from countries such as Armenia, Egypt and the UAE, and domestic locations such as St. Petersburg, Novosibirsk and Makhachkala – were redirected to other airports, according to the Vnukovo airport website.

       Vnukovo is one of four major airports that serve Moscow. The airport''s press office did not immediately respond to CNN''s requests for comment.',
           '2023-07-04 15:35:02',
           'https://plus.unsplash.com/premium_photo-1676923828394-0a981c5b833f?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1471&q=80',
           'Russian attack on Kharkiv region',
           1
       ),
    (
        'Nearly 62,000 people died heat-related deaths last year during Europe’s hottest summer on record, a new study has found — more heartbreaking evidence that heat is a silent killer, and its victims are vastly under-counted.

    The study, published Monday in the journal Nature Medicine, found that 61,672 died in Europe from heat-related illness between May 30 and September 4 last year. Italy was the hardest-hit country, with around 18,000 deaths, followed by Spain with just over 11,000 and Germany with around 8,000.

    Researchers also found the extreme heat disproportionately harmed the elderly and women. Of the nearly 62,000 deaths analyzed, heat-related mortality rate was 63% higher in women than in men. Age was also an important factor, with the death toll increasing significantly for people aged 65 and over.

    “It’s a very big number,” Joan Ballester, an epidemiologist at ISGlobal and the lead author of the study, told CNN.

    Eurostat, which is Europe’s statistical office, attempted to quantify the heat wave’s death toll last year by tallying excess deaths — or how many people died more than a typical summer. But Ballester, who lives in Spain and sweated through last year’s heat wave, said the study published Monday was the first to analyze how many deaths last summer were specifically caused by heat.

    Researchers analyzed temperature and mortality data between 2015 and 2022 for 35 European countries — representing a total population of 543 million people — and used it to create epidemiological models to calculate heat-related deaths.

    “For me, I’m an epidemiologist, so I know what to expect and (the number of deaths) is not surprising, but for the general population, it’s very likely that this is astonishing,” he said.

    The region has seen this script before — an unprecedented heat wave resulted in more than 70,000 excess deaths in the summer of 2003. That heat wave was an “exceptionally rare event,” the study’s scientists said, even when accounting for the human-caused climate crisis.

    The 2003 heat wave was a wake-up call, researchers said. It showed Europe at the time lacked the kind of preparedness to prevent a mass casualty event from heat, and it exposed the fragile nature of the region’s health system, Ballester said, particularly as weather extremes become more frequent and intense.',
        '2023-07-11 10:37:44',
        'https://media.istockphoto.com/id/1011128754/photo/thermometer-in-the-sky-the-heat.jpg?s=1024x1024&w=is&k=20&c=hcqMgnf6LJCiqkL3nJkp1c2JLR4GnWjW4WTn-7gS-jw=',
        'Nearly 62,000 people died from record-breaking heat in Europe last summer.',
        1
    ),
    (
        'Dissident Iranian rapper Toomaj Salehi, arrested last October for supporting the protest movement in Iran last year, has been sentenced to six years and three months in prison, his official Twitter page said Monday.

    “Toomaj Salehi was sentenced to 6 years and 3 months in prison, and after 252 days of solitary confinement, transferred to the general section of the prison,” the tweet said.

    The rapper, 32, was previously charged with crimes that are punishable by death, including “propagandistic activity against the government, cooperation with hostile governments and forming illegal groups with the intention of creating insecurity in the country,” Iranian state media IRNA had previously reported.

    Salehi’s lawyer, Reza Etemad Ansari, told Iranian daily newspaper Shargh on Monday that the rapper was “acquitted of insulting the Supreme Leader and cooperation with hostile governments.”

    Ansari told Shargh the rapper will be “banned from leaving the country for two years, and his passport will be revoked” adding that the rapper will be “banned from any activity, preparation and production of music and singing work for two years.”

    Salehi’s uncle, Iqbal Iqbali, said in a statement Monday that his nephew has been “unjustly imprisoned for six and a half years” and thanked supporters who have taken steps for the rapper’s release.

    “Your Toomaj, Iran’s Toomaj, the world’s Toomaj, and our Toomaj was unjustly imprisoned for six and a half years. May he and all of our political prisoners be released,” Iqbali said. “Thank you to all dear ones who have taken steps for the release of Toomaj and for the release of our political prisoners.”

    Salehi had expressed support online and in his songs for a wave of nationwide protests that were triggered by the death of Mahsa Amini, a 22-year-old Kurdish Iranian woman who died on September 16 after being detained by “morality police” and taken to a “re-education center,” allegedly for not wearing her hijab properly.

    When nationwide protests started in mid-September last year, Salehi called for Iranians to protest against the government.

    “None of us have different color blood,” Salehi posted on Instagram. “Don’t forget our amazing union and do not allow them to create division between us, in this bloody and sad heaven.”

    Salehi, who himself is of Bakhtiari ethnic background, has long rapped about Iran’s multi-ethnic makeup, encouraging unity among Iranians of different ethnic backgrounds.

    “Stand with us, we stood by you for years,” Salehi raps in his song “Meydoone jang” which translates as “The Battlefield.”

    “It’s not enough to be rebellious, we have revolutionary roots. Arab, Assyrian, Armenian, Turkmen, Mazandari, Sistani, Baluch, Talysh, Tatar, Azeri, Kurd, Gilaki, Lor, Farsi and Qashqai, we are the unity of rivers: we are the sea.”',
        '2023-07-11 10:52:17',
        'https://media.istockphoto.com/id/1369309661/photo/portrait-of-a-female-activist-in-a-protest-march-holding-a-megaphone-with-crows-behind-her.jpg?s=612x612&w=is&k=20&c=XnTCFY2_MKuo2EZ45ybpV3Qr-3cYqNragR6QlFeYvVc=',
        'Iranian rapper Toomaj Salehi sentenced to six years in prison, avoiding death penalty',
        1
    ),
    (
        'The New Democrat Coalition, which says it has a 98-House member bloc, is ramping up pressure on Speaker Kevin McCarthy to reject hardliners in his party and instead work with Republicans and Democrats to pass its annual defense legislation in a timely manner.

        “Speaker McCarthy must choose between caving to the most extreme elements of his party that seek to compromise our national defense or working with sensible lawmakers to support all of our troops,” New Democrat Coalition Chairs jointly announced Tuesday.

        The urge to pursue a bipartisan path comes as leadership must navigate right-wing lawmakers pushing for a slew of hot button amendments that could put moderate Republicans in a complicated position and threaten Democratic support for the must-pass bill.

        Late Tuesday, the House Rules Committee reconvened after a nearly seven-hour holdup, voting to report out a rule and allowing floor debate to begin as leadership works behind the scenes to solve issues with controversial amendments.

        The committee voted along party lines to proceed with floor debate with just some of the 1,500+ amendments. Lawmakers on the committee noted they will need to report out a separate, second rule with the rest of the amendments.

        The National Defense Authorization Act, which outlines the policy agenda for the Department of Defense and the US military and authorizes spending in line with the Pentagon’s priorities, passed out of the House Armed Services committee with overwhelming bipartisan support, even though some controversial GOP amendments – including a ban on drag shows on military bases and the reinstatement of troops who refused to comply with the Pentagon’s vaccine mandate – were adopted.

        While drama isn’t new in fights over the NDAA, which has been passed by Congress every year for the last six decades, this level of acrimony is notable. After receiving heat for the debt ceiling deal struck earlier this year, McCarthy is under increasing pressure to cater to his right flank, ratcheting up concerns about the ability for lawmakers to reach a compromise that both chambers can agree on.

        McCarthy signaled earlier Tuesday he felt no pressure to get the NDAA passed by Friday, insisting instead GOP leadership wants to get it “right.”

        Republicans can only afford to lose two votes on the committee on a party-line vote, and McCarthy placed three far-right members on the panel in exchange for becoming speaker. At least one of the conservative lawmakers on the panel, Rep. Ralph Norman of South Carolina, told CNN he plans to oppose the rule.

        Texas Rep. Chip Roy, a hardline conservative who sits on the Rules Committee, would not commit to supporting the rule.

        “We’ll see,” Roy told CNN as he walked into the speaker’s office on Tuesday. “That hinges a lot on the process.”

        This story has been updated Wednesday with additional updates.',
        '2023-07-12 13:56:07',
        'https://media.cnn.com/api/v1/images/stellar/prod/230525162623-us-capitol-dome-0420.jpg?c=16x9&q=h_720,w_1280,c_fill',
        'New Democrats ramp up pressure on defense bill as McCarthy faces pressure to appease the right',
        2
    ),
    (
        'China-based hackers have breached email accounts at two-dozen organizations, including some United States government agencies, in an apparent spying campaign aimed at acquiring sensitive information, according to statements from Microsoft and the White House late Tuesday.

        The full scope of the hack is being investigated, but US officials and Microsoft have been quietly scrambling in recent weeks to assess the impact of the hack and contain the fallout.

        The federal agency where the Chinese hackers were first detected was the State Department, a person familiar with the matter told CNN. The State Department then reported the suspicious activity to Microsoft, the person said.

        “Last month, US government safeguards identified an intrusion in Microsoft’s cloud security, which affected unclassified systems,” National Security Council spokesperson Adam Hodge said in a statement to CNN.

        “Officials immediately contacted Microsoft to find the source and vulnerability in their cloud service,” Hodge said. “We continue to hold the procurement providers of the US Government to a high-security threshold.”

        Hodge did not identify who was behind the hack, but Microsoft executives said in a blog post that the hackers were based in China and focused on espionage.

        There is still an “ongoing, active investigation” in the US government to understand the full scope of the hack, a source familiar with the matter told CNN.

        US officials have consistently labeled China as the most advanced of US adversaries in cyberspace. The FBI has said Beijing has a larger hacking program than all other governments combined.

        China has routinely denied the allegations. The Chinese Embassy in Washington, D.C., did not immediately respond to a request for comment early Wednesday on the Microsoft findings.

        The hacking began in mid-May when the China-based hackers used a stolen sign-in key to burrow their way into email accounts, according to Microsoft. The tech giant has since blocked the hackers from accessing customer emails using that technique, Microsoft said late Tuesday.

        This story has been updated with additional information.',
        '2023-07-12 13:55:00',
        'https://media.cnn.com/api/v1/images/stellar/prod/230712081156-china-hackers-us-government-email-file-040319.jpg?c=16x9&q=h_720,w_1280,c_fill',
        'China-based hackers breached US government email accounts, Microsoft and White House say',
        3
    ),
    (
        'Climate change combined with this year’s El Niño set a new world record for worldwide heat on Tuesday – 62.92 degrees Fahrenheit or 17.18 degrees Celsius.

        The low 60s may not sound that hot to anyone sweating through a summer heat wave, but the figure is almost a full degree Celsius above the average between 1979 and 2000 and represents a new indicator that Earth’s climate is heating up faster than anticipated.

        Expect more records this year
        Looking at the graphic in CNN’s report that tracks annual global temperatures, the hottest part of the year has not arrived. Expect more worldwide records before the fall.

        The record was first set on Monday when the average global temperature reached 17.01 degrees Celsius (62.62 degrees Fahrenheit), per the US National Centers for Environmental Prediction’s data.

        The European Union’s Copernicus Climate Change Service, which also tracks global temperatures using a different method, tweeted that Monday was a record in its dataset, with a global temperature of 16.88 degrees Celsius.

        The climate science consensus that world governments should seek to contain rising temperatures to within 1.5 degrees Celsius of pre-industrial levels seems more and more unattainable.

        The World Meteorological Organization, the Switzerland-based agency of the United Nations, said back in May that there is a two-thirds likelihood that temperatures would shoot past that 1.5 degrees Celsius threshold within the next five years.

        This year’s El Niño is not helping
        The cyclical phenomenon occurs when warm Pacific waters flow toward the west coast of the Americas and affect temperatures worldwide. The WMO declared the onset of an El Niño Tuesday and warned governments to prepare for more extreme weather events as a result.

        This will be the first El Niño in seven years. The last very strong El Niño year – 2016 – also saw the previous record for worldwide heat that August. It’s hard to believe, but the last few years, despite being among the hottest on record, were La Niña years, which should have relatively low temperatures.

        Learn to adapt
        Asked about the new record on CNN International, CNN’s chief climate correspondent Bill Weir said countries will need to work on adapting to the new climate as much as trying to mitigate climate change.

        “Unfortunately, the planet we grew up on, those dependable seasons, we’re not going back to that,” he said.

        He noted that there were heat records set around the planet this week including scorching temperatures over 120 degrees Fahrenheit (around 50 degrees Celsius) in parts of Africa. But relatively hot temperatures in other places around the world are important to chart.

        “Yesterday, way up in the Arctic Circle … the northernmost tip of Quebec, it was warmer than Miami,” Weir said. “And at the same time, at the bottom of the planet, which is supposed to be the polar opposite – it’s winter down there – they set a high-temperature record as well. So we’re seeing it all over the planet.”

        Set to blow past that 1.5-degree threshold
        John Abraham is a climate scientist and professor at the University of St. Thomas in Minnesota. He appeared after Weir on CNN International and was asked how these new records affect the target of keeping temperatures within 1.5 degrees Celsius of pre-industrial levels.

        “I hate to be the bearer of bad news, but we are going to blow through that target,” he said, adding humans are not doing enough to slow down greenhouse gas emissions after decades of burning fossil fuels.

        “It has been years and years of emitting the stuff into the atmosphere,” he said. “The heat is accumulating, and we are seeing the records that scientists have been predicting would occur many decades ago.”

        How temperatures rise
        He also offered an interesting framing for how to view rising temperatures: not as a steady ramp but rather in steps.

        “They rise like steps, like you are going up steps to get from the first floor to the second floor of a house,” Abraham said. “Every few years, the temperatures step up, and then they hold constant for a few years, and then they step up again.”

        Steps up, he said, coincide with El Niño events like this year’s.

        “It is El Niño on top of decades of human emissions of greenhouse gases.”

        There is no turning back, he said, but humans can likely slow the change.

        “We can change the trajectory,” Abraham said. “We can change how fast it rises, but we can’t arrest the rising.”

        But here’s a note of optimism
        I was somewhat surprised to hear Abraham close on a positive note, arguing the world is “at a tipping point right now in the economics of clean energy.”

        “You can now power your homes and your businesses and your cars with solar and wind power just as cheaply as with coal,” he argued.

        “In the old days, if you took climate change seriously, it was a personal, moral, ethical statement you were making. Now, it’s a financial statement you are making.”

        While the US and state governments have tried to incentivize people and companies to embrace lower-emission options, they are not yet as affordable as carbon-emitting alternatives. Plus, there is a documented push to seek out fossil fuel reserves by oil and gas companies, as Reuters documented this week.

        Or, more to the point of how oil and gas continue to influence the US economy: As world authorities were charting record worldwide temperatures, economic authorities saw gas prices dipping ahead of the July Fourth holiday as a major boon for inflation-weary consumers.',
        '2023-07-11 11:11:14',
        'https://media.cnn.com/api/v1/images/stellar/prod/230630104813-01-heat-wave-0629.jpg?c=16x9&q=h_720,w_1280,c_fill',
        'El Niño + climate change = heat records',
        4
    ),
INSERT INTO posts (post_content, created_at, image_url, post_title, category_id)
VALUES (
    'President Joe Biden will meet with Ukrainian President Volodymyr Zelensky at the NATO summit on Wednesday, an official familiar with the meeting has confirmed.

    The meeting will mark a sign of unity as Zelensky’s attendance at the summit had been in question. Russia’s war in Ukraine is among the top agenda items for NATO leaders along with discussing a future pathway for the war-torn country to join the alliance, which has prompted some division among leaders.

    Politico was first to report the meeting.

    Ukraine is set to dominate the summit’s agenda as the US president looks to keep the group united behind Zelensky in the face of Russia’s invasion. The alliance is facing questions about a potential path to NATO membership for Ukraine, as well as additional military assistance as its counteroffensive continues.

    Biden poured cold water on the prospect of Ukraine joining NATO as the war is ongoing and cited reforms the country would still need to make to join the alliance.

    “I don’t think there is unanimity in NATO about whether or not to bring Ukraine into the NATO family now, at this moment, in the middle of a war,” Biden told CNN’s Fareed Zakaria last week.

    Zelensky had previously said he does not plan on attending the summit “for fun” as he seeks a clearer pathway for his country to join the alliance along with security guarantees.

    “It would be an important message to say that NATO is not afraid of Russia. Ukraine should get clear security guarantees while it is not in NATO. Only under these conditions, our meeting would be meaningful, otherwise it’s just another politics,” Zelensky said in an interview with ABC.

    Biden and Zelensky have had multiple high-profile meetings over the last several months. The Ukrainian president’s first trip outside Ukraine since the war began was to Washington just before Christmas, where he was feted by Biden in the Oval Office before giving a speech to Congress.

    A couple months later, Biden made a surprise visit to Kyiv to return the favor and announce a half-billion-dollar assistance package. The dramatic scene was marked by air raid sirens going off as the two presidents walked near the gold-domed St. Michael’s Cathedral.

    Their last in-person meeting took place at the G-7 Summit in Hiroshima, Japan, in May. Zelensky used the opportunity to press the world leaders for more assistance, coming just after the Russians took the town of Bakhmut following months of heavy fighting.

    During this NATO summit, Biden could face some scolding from allies over his decision to provide cluster munitions to Ukraine for the first time. The move, aimed at bolstering Ukraine’s offensive capabilities, has prompted some public disagreement from allied countries. Biden called it a “difficult decision” in his interview with Zakaria but said it was necessary because Ukraine is running low on ammunition.

    Zelensky said Friday that Ukraine was grateful for a ‘timely, broad and much-needed’ defense aid package from the United States.

    “A timely, broad and much-needed defense aid package from the United States. We are grateful to the American people and President Joseph Biden for decisive steps that bring Ukraine closer to victory over the enemy and democracy to victory over dictatorship,” Zelensky said in a message on Twitter.

    “The expansion of Ukraine’s defense capabilities will provide new tools for the de-occupation of our land and bringing peace closer,” he said.

    This story has been updated with additional reporting.',
    '2023-07-11 11:08:13',
    'https://media.cnn.com/api/v1/images/stellar/prod/230521021512-02-biden-zelensky-g7-052123.jpg?c=16x9&q=h_720,w_1280,c_fill',
    'Biden to meet with Zelensky during NATO summit',
    6
    ),


INSERT INTO tags (tag_name)
VALUES ('Iran'),
       ('Toomaj Salehi'),
       ('Human Rights'),
       ('Europe'),
       ('Heatwave'),
       ('Climate Change'),
       ('Protests'),
       ('Ukraine'),
       ('Conflict');

INSERT INTO post_tags (post_id, tag_id)
VALUES (1, 1), (1, 2), (1, 3),
       (2, 4), (2, 5), (2, 6),
       (3, 7), (3, 8), (3, 9);
