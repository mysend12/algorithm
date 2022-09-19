package io.my;


/**
 * BigO 표기법
 * 초당 1억 번의 연산을 하는 CPU의 경우 초당 계산할 수 있는 데이터의 양.
 * 아래로 내려갈수록 느려짐.
 *
 * - O(1): 데이터의 크기와 상관없이 항상 일정한 시간이 걸린다. (즉시)
 * - O(logN): 데이터 양이 증가해도 시간이 조금씩 증가한다.
 * - O(N): 데이터 양에 따라 시간이 정비례한다. 위 CPU 기준, 초당 약 1억
 * - O(NlogN): 위 CPU 기준, 초당 약 500만
 * - O(N^2): 위 CPU 기준, 초당 약 1만
 * - O(N^3): 위 CPU 기준, 초당 약 500
 * - O(2^N): 위 CPU 기준, 초당 약 20
 * - O(N!): 위 CPU 기준, 초당 약 10
 */
public @interface BigONotation {
    String bestBigO();
    String averageBigO();
    String worstBigO();
    String description();
}
