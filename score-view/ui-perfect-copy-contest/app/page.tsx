import React from 'react';

interface User {
  id: number;
  name: string;
  iconUrl: string;
  score: number;
  submissionTime: string;
}

export default function Ranking() {
  const users: User[] = [
    { id: 1, name: '山田太郎', iconUrl: 'https://randomuser.me/api/portraits/men/1.jpg', score: 100, submissionTime: '10:00' },
    { id: 2, name: '鈴木一郎', iconUrl: 'https://randomuser.me/api/portraits/women/1.jpg', score: 95, submissionTime: '10:05' },
    { id: 3, name: '佐藤花子', iconUrl: 'https://randomuser.me/api/portraits/men/2.jpg', score: 90, submissionTime: '10:10' },
    { id: 4, name: '伊藤四郎', iconUrl: 'https://randomuser.me/api/portraits/women/2.jpg', score: 85, submissionTime: '10:15' },
    { id: 5, name: '高橋五郎', iconUrl: 'https://randomuser.me/api/portraits/men/3.jpg', score: 80, submissionTime: '10:20' },
    { id: 6, name: '田中六郎', iconUrl: 'https://randomuser.me/api/portraits/women/3.jpg', score: 75, submissionTime: '10:25' },
    { id: 7, name: '渡辺七郎', iconUrl: 'https://randomuser.me/api/portraits/men/4.jpg', score: 70, submissionTime: '10:30' },
    { id: 8, name: '小林八郎', iconUrl: 'https://randomuser.me/api/portraits/women/4.jpg', score: 65, submissionTime: '10:35' },
    { id: 9, name: '加藤九郎', iconUrl: 'https://randomuser.me/api/portraits/men/5.jpg', score: 60, submissionTime: '10:40' },
    { id: 10, name: '吉田十郎', iconUrl: 'https://randomuser.me/api/portraits/women/5.jpg', score: 55, submissionTime: '10:45' },
  ];

  return (
    <div className="max-w-2xl mx-auto min-h-screen py-6">
      <h2 className="text-2xl font-bold text-center dark:text-white">ランキング</h2>
      <ul className='p-6'>
        {users.map((user, index) => (
          <li key={user.id} className={`flex items-center bg-white shadow-lg rounded-lg overflow-hidden my-4 ${index === 0 ? 'p-6' :index < 3 ? 'p-5' : 'p-4'} ${index === 0 ? 'bg-yellow-200 dark:bg-yellow-500' : index < 3 ? 'bg-gray-100 dark:bg-gray-500' : 'dark:bg-gray-700 '}`}>
            <div className={`flex-shrink-0 ${index === 0 ? 'w-24 h-24' :index < 3 ? 'w-20 h-20' : 'w-16 h-16'}`}>
              <img src={user.iconUrl} alt={user.name} className={`rounded-full ${index === 0 ? 'border-4 border-yellow-500 dark: border-yellow-600' : index < 3 ? 'border-4 border-gray-400 dark:border-gray-600' : ''}`} />
            </div>
            <div className="ml-4">
              <span className={`font-bold ${index === 0 ? 'text-lg' : index < 3 ? 'text-lg' : 'text-md'} dark:text-white`}>{user.name}</span>
              <span className={`block ${index === 0 ? 'text-lg' : index < 3 ? 'text-md' : 'text-sm'} dark:text-gray-300`}>{user.score} 点</span>
              <span className={`block ${index === 0 ? 'text-md' : index < 3 ? 'text-sm' : 'text-xs'} dark:text-gray-300`}>{user.submissionTime} 提出</span>
            </div>
            <span className={`ml-auto mr-4 font-bold ${index === 0 ? 'text-2xl' : index < 3 ? 'text-xl' : 'text-lg'} dark:text-white`}>{index + 1}位</span>
          </li>
        ))}
      </ul>
    </div>
  );
}
