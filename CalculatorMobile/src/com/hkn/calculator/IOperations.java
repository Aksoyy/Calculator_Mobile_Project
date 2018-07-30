package com.hkn.calculator;
/*Kullanıcıdan alınan parametlerin web servise gitmesi icin
 *gerekli metodları belirtmektedir. Bu metodları kullanırken
 *web servisi açmayı unutmamalıyız.
 */
public interface IOperations
{
	public CalcResult Sum(CalcInput input);
	public CalcResult Minus(CalcInput input);
	public CalcResult Division(CalcInput input);
	public CalcResult Mode(CalcInput input);
	public CalcResult Multi(CalcInput input);
	public CalcResult getUpper(CalcInput input);
}
