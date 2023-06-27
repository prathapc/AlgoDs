package com.practice.B_algo_ps.A_arrays.intervals;

import java.util.Arrays;

/**
 * Created by prathapchowdary on 27/05/22.
 *
 * https://leetcode.com/problems/meeting-rooms-ii/
 */
public class N_MeetingRoomsII {

    public int minMeetingRooms(int[][] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for(int i=0; i<intervals.length; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int rooms = 0;
        int endsItr = 0;
        for(int i=0; i<starts.length; i++) {
            if(starts[i]<ends[endsItr])
                rooms++;
            else
                endsItr++;
        }
        return rooms;
    }

    //https://leetcode.com/problems/meeting-rooms/
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (int[] i, int[] j) -> i[0] - j[0]);
        for (int i=1; i<intervals.length; i++) {
            if (intervals[i][0] < intervals[i-1][1]) return false;
        }
        return true;
    }

    //https://leetcode.com/discuss/interview-question/613816/Google-or-Onsite-or-Meeting-Rooms-3
    //Sol: we can use either of above two problem solutions to solve this
    //OR another optimized solution below
    public boolean[] canAddMeetingToCalender(int[][] calendar, int rooms, int[][] queries) {
        Arrays.sort(calendar , (a,b) -> a[0] - b[0]);
        int n = calendar[calendar.length-1][1];
        int dp[] = new int[n+1];
        for(int i=0;i<calendar.length;i++) {
            int start = calendar[i][0];
            int end = calendar[i][1];
            while(start<end) {
                dp[start]++;
                start++;
            }
        }

        boolean[] result = new boolean[queries.length];

        for(int i=0;i<queries.length;i++) {
            int start = queries[i][0];
            int end = queries[i][1];

            while (start < end) {
                if (dp[start] >= rooms) {
                    result[i] = false;
                    break;
                }
                if (start == end-1)
                    result[i] = true;
                start++;
            }
        }
        return result;
    }
}
