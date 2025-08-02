// src/components/ScoreBelow70.js
export default function ScoreBelow70({ players }) {
  const filtered = players.filter((item) => item.score <= 70);
  return (
    <ul>
      {filtered.map((item, index) => (
        <li key={index}>
          Mr. {item.name} <span>{item.score}</span>
        </li>
      ))}
    </ul>
  );
}
