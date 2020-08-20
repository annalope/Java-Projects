' Program: Basketball Scoreboard
' Name: Anna Ivanisevic
' Date: 7/08/19

Public Class BasketballScoreboard
    ' declares Names variables
    Dim strHomeTeamName As String
    Dim strAwayTeamName As String
    Dim intMinutesLeft As Integer
    Dim intCounter As Integer = 1
    Dim strSecondsLeft As String
    ' Declares points and fouls variables
    Dim intPointsHome As Integer = 0
    Dim intPointsAway As Integer = 0
    Dim intFoulsHome As Integer = 0
    Dim intFoulsAway As Integer = 0
    ' Declares winer variables
    Dim strWinner As String
    ' Declares time counters
    Dim intTimerCount As Integer = 59
    Dim intMinCount As Integer = 1


    Private Sub txtHomeTeam_TextChanged(sender As Object, e As EventArgs) Handles txtHomeTeam.TextChanged
        ' Sets Home Team name
        strHomeTeamName = txtHomeTeam.Text
        Me.lblHomeTeamControls.Text = strHomeTeamName & " Controls"
        Me.lblHomeTeamName.Text = strHomeTeamName & " Scoreboard"
        Me.lblHomeNameBonus.Text = strHomeTeamName
    End Sub

    Private Sub txtAwayTeam_TextChanged(sender As Object, e As EventArgs) Handles txtAwayTeam.TextChanged
        ' Sets away team name
        strAwayTeamName = txtAwayTeam.Text
        Me.lblAwayTeamControls.Text = strAwayTeamName & " Controls"
        Me.lblAwayTeamName.Text = strAwayTeamName & " Scoreboard"
        Me.lblAwayNameBonus.Text = strAwayTeamName
    End Sub

    Private Sub ResetAwayTeamToolStripMenuItem_Click(sender As Object, e As EventArgs) Handles ResetAwayTeamToolStripMenuItem.Click
        ' Exit button
        Application.Exit()
    End Sub

    Private Sub txtMinutes_TextChanged(sender As Object, e As EventArgs) Handles txtMinutes.TextChanged
        ' Sets minutes
        Try ' Checks to make sure only numbers are entered
            intMinutesLeft = txtMinutes.Text
            Me.lblMinutesLeft.Text = intMinutesLeft
        Catch Ex As Exception
            MessageBox.Show("Please enter only numbers into the timer.")
        End Try
    End Sub

    Private Sub btnPauseTime_Click(sender As Object, e As EventArgs) Handles btnPauseTime.Click
        ' Pauses time
        timSeconds.Enabled = False
    End Sub


    Private Sub btnTimeUpdated_Click(sender As Object, e As EventArgs) Handles btnTimeBegin.Click
        ' Begins the time
        timSeconds.Interval = 1000 ' number of milliseconds in a second
        timMinutes.Interval = 1000
        timSeconds.Enabled = True ' starts the seconds timer
        timMinutes.Enabled = True ' starts the minutes timer
        Me.lblMinutesLeft.Text = intMinutesLeft

    End Sub

    Private Sub btnResetBonHome_Click(sender As Object, e As EventArgs) Handles btnResetBonHome.Click
        ' Resets home bonus
        radYesBonHome.Checked = False
        radNoBonHome.Checked = False
        Me.lblHomeBonus.Text = "No"
    End Sub

    Private Sub btnResetBonAway_Click(sender As Object, e As EventArgs) Handles btnResetBonAway.Click
        ' resets away bonus
        radYesBonAway.Checked = False
        radNoBonAway.Checked = False
        Me.lblAwayBonus.Text = "No"
    End Sub

    Private Sub btn1PtHome_Click(sender As Object, e As EventArgs) Handles btn1PtHome.Click
        ' adds a point to home team
        intPointsHome += 1
        Me.lblPointsHome.Text = intPointsHome
    End Sub

    Private Sub btn2PtHome_Click(sender As Object, e As EventArgs) Handles btn2PtHome.Click
        ' adds two points to home team
        intPointsHome += 2
        Me.lblPointsHome.Text = intPointsHome
    End Sub

    Private Sub btn3PtHome_Click(sender As Object, e As EventArgs) Handles btn3PtHome.Click
        ' adds three points to home team
        intPointsHome += 3
        Me.lblPointsHome.Text = intPointsHome
    End Sub

    Private Sub btn1FlHome_Click(sender As Object, e As EventArgs) Handles btn1FlHome.Click
        ' adds a foul to home team
        intFoulsHome += 1
        Me.lblFoulsHome.Text = intFoulsHome
    End Sub

    Private Sub btn1FlAway_Click(sender As Object, e As EventArgs) Handles btn1FlAway.Click
        ' adds a foul to away team
        intFoulsAway += 1
        Me.lblFoulsAway.Text = intFoulsAway
    End Sub

    Private Sub btn1PtAway_Click(sender As Object, e As EventArgs) Handles btn1PtAway.Click
        ' adds a point to away team
        intPointsAway += 1
        Me.lblPointsAway.Text = intPointsAway
    End Sub

    Private Sub btn2PtAway_Click(sender As Object, e As EventArgs) Handles btn2PtAway.Click
        ' adds two points to away team
        intPointsAway += 2
        Me.lblPointsAway.Text = intPointsAway
    End Sub

    Private Sub btn3PtAway_Click(sender As Object, e As EventArgs) Handles btn3PtAway.Click
        ' adds three points to away team
        intPointsAway += 3
        Me.lblPointsAway.Text = intPointsAway
    End Sub

    Private Sub ResetHomeTeamToolStripMenuItem2_Click(sender As Object, e As EventArgs) Handles ResetHomeTeamToolStripMenuItem2.Click
        ' resets home team
        Me.lblPointsHome.Text = "0"
        Me.lblFoulsHome.Text = "0"
        Me.lblHomeBonus.Text = "No"
        radYesBonHome.Checked = False
        radNoBonHome.Checked = False
        txtHomeTeam.Text = Nothing
        Me.lblHomeTeamControls.Text = "Home Team Controls"
        Me.lblHomeTeamName.Text = "Home Scoreboard"
        Me.lblHomeNameBonus.Text = "Home"
    End Sub

    Private Sub ResetAwayTeamToolStripMenuItem2_Click(sender As Object, e As EventArgs) Handles ResetAwayTeamToolStripMenuItem2.Click
        ' resets away team
        Me.lblPointsAway.Text = "0"
        Me.lblFoulsAway.Text = "0"
        Me.lblAwayBonus.Text = "No"
        radYesBonAway.Checked = False
        radNoBonAway.Checked = False
        txtAwayTeam.Text = Nothing
        Me.lblAwayTeamControls.Text = "Away Team Controls"
        Me.lblAwayNameBonus.Text = "Away"
        Me.lblAwayTeamName.Text = "Away Scoreboard"
    End Sub

    Private Sub ResetTimeToolStripMenuItem1_Click(sender As Object, e As EventArgs) Handles ResetTimeToolStripMenuItem1.Click
        ' resets time

        txtMinutes.Text = Nothing
        Me.lblMinutesLeft.Text = "00"
        Me.lblSecondsLeft.Text = "00"
    End Sub

    Private Sub ResetAllToolStripMenuItem_Click(sender As Object, e As EventArgs) Handles ResetAllToolStripMenuItem.Click
        ' resets entire form
        Me.lblPointsAway.Text = "0"
        Me.lblFoulsAway.Text = "0"
        Me.lblAwayBonus.Text = "No"
        Me.lblPointsHome.Text = "0"
        Me.lblFoulsHome.Text = "0"
        Me.lblHomeBonus.Text = "No"
        radNoBonAway.Checked = False
        radYesBonAway.Checked = False
        radNoBonHome.Checked = False
        radYesBonHome.Checked = False
        Me.lblPeriod.Text = "..."
        Me.lblHomeBonus.Text = "No"
        Me.lblAwayBonus.Text = "No"
        radPeriod1.Checked = False
        radPeriod2.Checked = False
        radPeriod3.Checked = False
        radPeriod4.Checked = False
        txtHomeTeam.Text = Nothing
        txtAwayTeam.Text = Nothing
        txtMinutes.Text = Nothing

        Me.lblHomeTeamControls.Text = "Home Team Controls"
        Me.lblAwayTeamControls.Text = "Away Team Controls"
        Me.lblAwayTeamName.Text = "Away Scoreboard"
        Me.lblHomeTeamName.Text = "Home Scoreboard"
        Me.lblHomeNameBonus.Text = "Home"
        Me.lblAwayNameBonus.Text = "Away"
        Me.lblMinutesLeft.Text = "00"
        Me.lblSecondsLeft.Text = "00"
    End Sub

    Private Sub radYesBonAway_Checked(sender As Object, e As EventArgs) Handles radYesBonAway.CheckedChanged
        ' sets a bonus for away team
        lblAwayBonus.Text = "Yes"
    End Sub

    Private Sub radNoBonAway_CheckedChanged(sender As Object, e As EventArgs) Handles radNoBonAway.CheckedChanged
        ' sets no bonus for away team
        lblAwayBonus.Text = "No"
    End Sub

    Private Sub radYesBonHome_CheckedChanged(sender As Object, e As EventArgs) Handles radYesBonHome.CheckedChanged
        ' sets a bonus for home team
        lblHomeBonus.Text = "Yes"
    End Sub

    Private Sub radNoBonHome_CheckedChanged(sender As Object, e As EventArgs) Handles radNoBonHome.CheckedChanged
        ' sets no bonus for home team
        lblHomeBonus.Text = "No"
    End Sub

    Private Sub radPeriod1_Checked(sender As Object, e As EventArgs) Handles radPeriod1.CheckedChanged
        ' sets period as 1
        lblPeriod.Text = "1"
    End Sub

    Private Sub radPeriod2_Checked(sender As Object, e As EventArgs) Handles radPeriod2.CheckedChanged
        ' sets period as 2
        lblPeriod.Text = "2"
    End Sub

    Private Sub radPeriod3_Checked(sender As Object, e As EventArgs) Handles radPeriod3.CheckedChanged
        ' sets period as 3
        lblPeriod.Text = "3"
    End Sub

    Private Sub radPeriod4_Checked(sender As Object, e As EventArgs) Handles radPeriod4.CheckedChanged
        ' sets period as 4
        lblPeriod.Text = "4"
    End Sub

    Private Sub ResetPeriodToolStripMenuItem_Click(sender As Object, e As EventArgs) Handles ResetPeriodToolStripMenuItem.Click
        ' resets period through menu strip
        radPeriod1.Checked = False
        radPeriod2.Checked = False
        radPeriod3.Checked = False
        radPeriod4.Checked = False
        lblPeriod.Text = "..."
    End Sub

    Private Sub MenuNavigationToolStripMenuItem_Click(sender As Object, e As EventArgs) Handles MenuNavigationToolStripMenuItem.Click
        MessageBox.Show("On your screen there are four 'menus'. They are each a different color. The Home Team Control Menu is Dark Blue. The Away Team Control Menu is Red. The Scoreboard Menu is Purple. The Game Control Menu is Light Blue. The Home Team Control Menu allows the operator to operate the Home Team scoreboard. The Away Team Control Menu allows the operator to operate the Away Team scoreboard. The Game Control Menu allows the operator to change the period, time, and name the teams. The Scoreboard Menu displays the output of user's input.")
    End Sub

    Private Sub PointsHelpToolStripMenuItem_Click(sender As Object, e As EventArgs) Handles PointsHelpToolStripMenuItem.Click
        MessageBox.Show("There are two ways to record points in this program. The first is located in the Home Team Control Menu and the second in the Away Team Control Menu (see 'Menu Navigation'). In the Home Team Control Menu and the Away Team Control Menu, there is a line that says 'Add Points:'. The operator may click on the buttons that say '1', '2', and '3' to add that number of points. The points are then displayed on the Scoreboard Menu. The points will be automatically added to the total each time a button is clicked. The points can be found under the team name (See 'Naming Teams').")
    End Sub

    Private Sub FoulsHelpToolStripMenuItem_Click(sender As Object, e As EventArgs) Handles FoulsHelpToolStripMenuItem.Click
        MessageBox.Show("There are two ways to record fouls in this program. The first is located in the Home Team Control Menu and the second in the Away Team Control Menu (see 'Menu Navigation'). In both Menus there is a line of text that reads 'Add Foul:'. Following this line of text is a button with the number 1 on it. Clicking this number 1 will increase the count of fouls for the team in the Scoreboard Menu. To reset all all of the fouls, the user may go up to the 'Reset' button in the Menu Strip and select 'Reset Fouls' from the options in the drop-down.")
    End Sub

    Private Sub timSeconds_Tick(sender As Object, e As EventArgs) Handles timSeconds.Tick
        Me.lblSecondsLeft.Text = intTimerCount.ToString() ' displays on the label
        If intTimerCount = 0 Then
            intMinutesLeft -= 1
            Me.lblMinutesLeft.Text = intMinutesLeft
            intTimerCount = 59
            timSeconds.Enabled = True
        Else
            intTimerCount -= 1
        End If
        If intTimerCount = 0 And intMinutesLeft = 0 Then
            timSeconds.Enabled = False
            Me.lblSecondsLeft.Text = "00"
            intTimerCount = 59
        End If
        If intMinutesLeft = 0 Then
            Me.lblMinutesLeft.Text = "00"
            intMinutesLeft = 0
        End If
    End Sub

    Private Sub TimeHelpToolStripMenuItem_Click(sender As Object, e As EventArgs) Handles TimeHelpToolStripMenuItem.Click
        MessageBox.Show("To display the time, go to the Game Control Menu. In it, there is a heading that reads 'Time in each period:'. In the text box next to the word 'minutes' the operator can type in the number of minutes into it. To begin the clock countdown, press the button that says 'Start Time'. To pause the clock, press the button that says 'Pause Time'. To begin it again, press the button that says 'Unpause'. To reset the clock back to zero, click on the 'Reset' button on the Menu Strip and select the 'Reset Time' option.")
    End Sub

    Private Sub BonusHelpToolStripMenuItem_Click(sender As Object, e As EventArgs) Handles BonusHelpToolStripMenuItem.Click
        MessageBox.Show("To add a bonus to a team, go to their Control Menu and select 'Yes' in the Bonus box. To remove it, select 'No'. To reset both bonuses, go to the 'Reset' drop-down in the Menu Strip and select 'Reset Bonus'. To reset one specific team's Bonus, click the button in the team's Control Menu that says 'Reset Bonus'.")
    End Sub

    Private Sub PeriodHelpToolStripMenuItem_Click(sender As Object, e As EventArgs) Handles PeriodHelpToolStripMenuItem.Click
        MessageBox.Show("To select the period, go to the Game Time Controls Menu and select the period from the radio buttons offered. The period will then be automatically displayed in the Scoreboard Menu. To reset the period, click on the 'Reset' option in the Menu Strip and select 'Reset Period'.")
    End Sub

    Private Sub NamingHelpToolStripMenuItem_Click(sender As Object, e As EventArgs) Handles NamingHelpToolStripMenuItem.Click
        MessageBox.Show("To name the teams, go to the Game Time Controls Menu and type in the name of the home team and the away team. They will automatically update. To reset the names, click on the 'Reset' option in the Menu Strip and select 'Reset Names'.")
    End Sub

    Private Sub ResetPointsToolStripMenuItem_Click(sender As Object, e As EventArgs) Handles ResetPointsToolStripMenuItem.Click
        intPointsHome = 0
        intPointsAway = 0
        Me.lblPointsHome.Text = intPointsHome
        Me.lblPointsAway.Text = intPointsAway
    End Sub

    Private Sub ResetFoulsToolStripMenuItem_Click(sender As Object, e As EventArgs) Handles ResetFoulsToolStripMenuItem.Click
        intFoulsHome = 0
        intFoulsAway = 0
        Me.lblFoulsHome.Text = intFoulsHome
        Me.lblFoulsAway.Text = intFoulsAway
    End Sub

    Private Sub ResetNamesToolStripMenuItem_Click(sender As Object, e As EventArgs) Handles ResetNamesToolStripMenuItem.Click
        txtAwayTeam.Text = Nothing
        txtHomeTeam.Text = Nothing
        strHomeTeamName = "Home"
        strAwayTeamName = "Away"
        Me.lblHomeTeamControls.Text = "Home Team Controls"
        Me.lblAwayTeamControls.Text = "Away Team Controls"
        Me.lblHomeNameBonus.Text = "Home"
        Me.lblAwayNameBonus.Text = "Away"
        Me.lblHomeTeamName.Text = "Home Scoreboard"
        Me.lblAwayTeamName.Text = "Away Scoreboard"
    End Sub

    Private Sub PrintToolStripMenuItem_Click(sender As Object, e As EventArgs) Handles PrintToolStripMenuItem.Click
        Dim strPoints As String = " Points: "
        Dim strPeriod As String = " . "
        Dim strFouls As String = " Fouls: "
        Dim strTheWinnerIs As String = "The winner is "
        If intPointsHome > intPointsAway Then
            strWinner = strHomeTeamName
        Else
            strWinner = strAwayTeamName
        End If
        MessageBox.Show(strHomeTeamName + strPoints + intPointsHome + strPeriod + strAwayTeamName + strPoints + intPointsAway + strPeriod + strHomeTeamName + strFouls + intFoulsHome + strPeriod + strAwayTeamName + strFouls + intFoulsAway + strPeriod + strTheWinnerIs + strWinner)
        ' Debug.Print(strHomeTeamName + strPoints + intPointsHome + strPeriod + strAwayTeamName + strPoints + intPointsAway + strPeriod + strHomeTeamName + strFouls + intFoulsHome + strPeriod + strAwayTeamName + strFouls + intFoulsAway + strPeriod + strTheWinnerIs + strWinner)
    End Sub

    Private Sub btnResetTime_Click(sender As Object, e As EventArgs) Handles btnResetTime.Click
        timSeconds.Enabled = False ' stops timer
        intTimerCount = 60 ' resets to 60 seconds
        Me.lblSecondsLeft.Text = "00" ' resets seconds label
        Me.lblMinutesLeft.Text = "00" ' resets minutes label
    End Sub

    Private Sub timMinutes_Tick(sender As Object, e As EventArgs) Handles timMinutes.Tick
        If intMinCount = 0 Then
            intMinutesLeft -= 1
            Me.lblMinutesLeft.Text = intMinutesLeft
            timMinutes.Enabled = False
        Else
            intMinCount -= 1
        End If
    End Sub

    Private Sub btnUnpause_Click(sender As Object, e As EventArgs) Handles btnUnpause.Click
        ' unpauses the time
        timSeconds.Enabled = True
    End Sub


End Class
