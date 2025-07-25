USE [SMS_DB]
GO
SET IDENTITY_INSERT [dbo].[courses] ON 

INSERT [dbo].[courses] ([capacity], [course_id], [description], [title]) VALUES (30, 1, N'Comprehensive course on Java with hands-on projects.', N'Java Programming')
INSERT [dbo].[courses] ([capacity], [course_id], [description], [title]) VALUES (3, 2, N'Comprehensive course on Python with hands-on projects.', N'Python Programming')
INSERT [dbo].[courses] ([capacity], [course_id], [description], [title]) VALUES (4, 3, N'Comprehensive course on C# with hands-on projects.', N'C# Programming')
SET IDENTITY_INSERT [dbo].[courses] OFF
GO
SET IDENTITY_INSERT [dbo].[students] ON 

INSERT [dbo].[students] ([dob], [student_id], [email], [father_name], [student_name]) VALUES (CAST(N'2000-05-10' AS Date), 1, N'imran.akbar@example.com', N'Akbar', N'Imran')
INSERT [dbo].[students] ([dob], [student_id], [email], [father_name], [student_name]) VALUES (CAST(N'2000-05-10' AS Date), 2, N'kamran.hyder@example.com', N'Hyder', N'Kamran')
INSERT [dbo].[students] ([dob], [student_id], [email], [father_name], [student_name]) VALUES (CAST(N'2000-05-10' AS Date), 3, N'faizan.imran@example.com', N'Imran', N'Faizan')
INSERT [dbo].[students] ([dob], [student_id], [email], [father_name], [student_name]) VALUES (CAST(N'2000-05-10' AS Date), 5, N'faizan.imran.siddiqui@example.com', N'Imran1', N'Faizan Siddiqui')
INSERT [dbo].[students] ([dob], [student_id], [email], [father_name], [student_name]) VALUES (CAST(N'2000-05-10' AS Date), 6, N'faizan2.imran@example.com', N'Imran2', N'Faizan2')
INSERT [dbo].[students] ([dob], [student_id], [email], [father_name], [student_name]) VALUES (CAST(N'2000-05-10' AS Date), 7, N'zeeshan.ali@example.com', N'Ali', N'Zeeshan')
INSERT [dbo].[students] ([dob], [student_id], [email], [father_name], [student_name]) VALUES (CAST(N'2000-05-10' AS Date), 8, N'waheed.ali@example.com', N'Ali', N'Waheed')
INSERT [dbo].[students] ([dob], [student_id], [email], [father_name], [student_name]) VALUES (CAST(N'2000-05-10' AS Date), 9, N'ahmed.ali@example.com', N'Ali', N'Ahmed')
INSERT [dbo].[students] ([dob], [student_id], [email], [father_name], [student_name]) VALUES (CAST(N'2000-05-10' AS Date), 10, N'Faraz.ali@example.com', N'Ali', N'Faraz')
INSERT [dbo].[students] ([dob], [student_id], [email], [father_name], [student_name]) VALUES (CAST(N'2000-05-10' AS Date), 11, N'usman.ali@example.com', N'Ali', N'Usman')
INSERT [dbo].[students] ([dob], [student_id], [email], [father_name], [student_name]) VALUES (CAST(N'2000-05-10' AS Date), 12, N'akash.kumar@example.com', N'Kumar', N'Aakash')
SET IDENTITY_INSERT [dbo].[students] OFF
GO
SET IDENTITY_INSERT [dbo].[enrollments] ON 

INSERT [dbo].[enrollments] ([completed], [enrollment_date], [marks], [course_id], [id], [student_id], [grade]) VALUES (0, NULL, NULL, 1, 1, 1, NULL)
INSERT [dbo].[enrollments] ([completed], [enrollment_date], [marks], [course_id], [id], [student_id], [grade]) VALUES (0, NULL, NULL, 2, 2, 1, NULL)
INSERT [dbo].[enrollments] ([completed], [enrollment_date], [marks], [course_id], [id], [student_id], [grade]) VALUES (0, NULL, NULL, 3, 3, 1, NULL)
INSERT [dbo].[enrollments] ([completed], [enrollment_date], [marks], [course_id], [id], [student_id], [grade]) VALUES (0, NULL, NULL, 2, 4, 2, NULL)
INSERT [dbo].[enrollments] ([completed], [enrollment_date], [marks], [course_id], [id], [student_id], [grade]) VALUES (0, NULL, NULL, 2, 5, 3, NULL)
SET IDENTITY_INSERT [dbo].[enrollments] OFF
GO
