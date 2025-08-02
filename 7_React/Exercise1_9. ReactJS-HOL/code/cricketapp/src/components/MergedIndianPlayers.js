// src/components/MergedIndianPlayers.js
export function MergedIndianPlayers() {
  const T20Players = ['First Player', 'Second Player', 'Third Player'];
  const RanjiPlayers = ['Fourth Player', 'Fifth Player', 'Sixth Player'];
  const merged = [...T20Players, ...RanjiPlayers];

  return (
    <ul>
      {merged.map((item, index) => (
        <li key={index}>Mr. {item}</li>
      ))}
    </ul>
  );
}
