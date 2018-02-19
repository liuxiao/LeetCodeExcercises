package com.cloudlewis.leetcode.facebook;

/**
 * 
 * 
 * Considering that I'ld would like to spread a promotion message across all
 * people in twitter. Assuming the ideal case, if a person tweets a message,
 * then every follower will re-tweet the message.
 * 
 * You need to find the minimum number of people to reach out (for example, who
 * doesn't follow anyone etc) so that your promotion message is spread out
 * across entire network in twitter.
 * 
 * Also, we need to consider loops like, if A follows B, B follows C, C follows
 * D, D follows A (A -> B -> C -> D -> A) then reaching only one of them is
 * sufficient to spread your message.
 * 
 * Input: A 2x2 matrix like below. In this case, a follows b, b follows c, c
 * follows a.
 * 
 * @formatter:off
 *    a b c
 * a  1 1 0
 * b  0 1 1
 * c  1 0 1
 * 
 * @formatter:on
 * Output: List of people to be reached to spread out message across everyone in
 * the network.
 * 
 * @author xiao
 *
 */
/*
 * step 1. Build a directed graph based on the input people (nodes) and their
 * relationship (edges).
 * 
 * step 2. Find strongly connected components (SCCs) in the graph. Let's use the
 * wikipedia's graph example, in that case, there are 3 SCCs: (a, b, e), (c, d,
 * h) and (f, g). There are two famous algorithms for getting the SCCs:
 * Kosaraju's algorithm and Tarjan's algorithm.
 * 
 * step 3. Pick one of the nodes from the SCCs we get: a, c, f, now these 3
 * nodes form a DAG, we just need to do topological sort for them, eventually a
 * is the root node in the path (or stack), and we can let a spread the message
 * and guarantee all other people will get it.
 * 
 * Sometimes, there could be several topological paths, and the root nodes of
 * those paths will be the minimum people to reach out to spread the message.
 * 
 * Nov 10, 2015, 8:14 PM reply quote
 * 
 */
public class MinimumPeopleToSpreadMessage {

}
